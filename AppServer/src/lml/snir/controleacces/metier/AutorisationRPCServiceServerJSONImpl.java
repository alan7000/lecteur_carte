package lml.snir.controleacces.metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Autorisation;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.entity.Evenement;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author fanou
 */
public class AutorisationRPCServiceServerJSONImpl implements AutorisationRPCService {

    @Override
    public Boolean isAutorise(String badgeContent, Integer salle, String date) throws Exception {
        Personne p = null;
        Date d = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date);
        boolean autorized = false;
        Badge b = MetierFactory.getBadgeService().getByContenu(badgeContent);
        Salle s = MetierFactory.getSalleService().getById((long) salle);

        if (s != null) {
            if (!s.isProtege()) {
                autorized = true;
            } else {
                if (b != null) {
                    AttributionService attrSrv = MetierFactory.getAttributionService();
                    Attribution attr = attrSrv.getByBadge(b);
                    if (attr != null) {
                        p = attr.getPersonne();
                        AutorisationService authSrv = MetierFactory.getAutorisationService();
                        List<Autorisation> autorisations = authSrv.getByPeronneEtSalle(p, s);
                        for (Autorisation a : autorisations) {
                            if (a.getPlageHoraire().isIn(d)) {
                                autorized = true;
                                break;
                            }
                        }
                    }

                }
            }
        }

        if (p != null) {
            // create event
            Evenement evt = new Evenement();
            evt.setAutorise(autorized);
            evt.setDate(d);
            evt.setPersonne(p);
            evt.setSalle(s);

            MetierFactory.getEvenementService().add(evt);
        }

        return autorized;
    }
}
