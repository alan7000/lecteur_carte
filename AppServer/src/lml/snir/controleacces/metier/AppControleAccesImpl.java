package lml.snir.controleacces.metier;

import java.util.Observable;
import java.util.Observer;
import lml.snir.controleacces.physique.io.LecteurRFIDDriver;
import lml.snir.controleacces.physique.io.PhysiqueIOFactory;

public class AppControleAccesImpl implements AppControleAcces, Observer {

    private final LecteurRFIDDriver lecteurRFID;

    AppControleAccesImpl() throws Exception {
        this.lecteurRFID = PhysiqueIOFactory.getLecteurRFID();
        this.lecteurRFID.addObserver(this);
    }

//    @Override
//    public Evenement autoriserAcces(Personne personne, Salle salle, Date date) throws Exception {
//        System.out.println("demande autorisation d'accès pour " + personne + " à la salle " + salle);
//        Evenement evt = new Evenement();
//        evt.setPersonne(personne);
//        evt.setSalle(salle);
//        evt.setDate(date);
//        evt.setAutorise(false);
//        if (salle.isProtege()) {
//            int day = date.getDay();
//            AutorisationService autorisationSrv = MetierFactory.getAutorisationService();
//            List<Autorisation> autorisations = autorisationSrv.getByPeronneEtSalle(personne, salle);
//            if (!autorisations.isEmpty()) {
//                for (Autorisation autorisation : autorisations) {
//
//                    PlageHoraire pl = autorisation.getPlageHoraire();
//                    Jour jour = pl.getJour();
//                    int heure = date.getHours();
//                    int minutes = date.getMinutes();
//
//                    if (day == jour.ordinal()) {
//                        boolean ok = false;
//                        // verif heure debut                    
//                        if (heure == pl.getHeureDebut().getHeure()) {
//                            if (minutes >= pl.getHeureDebut().getMinute()) {
//                                ok = true;
//                            }
//                        } else {
//                            if (heure > pl.getHeureDebut().getHeure()) {
//                                ok = true;
//                            }
//                        }
//
//                        if (ok) {
//                            ok = false;
//                            // heure de fin
//                            if (heure < pl.getHeureFin().getHeure()) {
//                                ok = true;
//                            } else {
//                                if (heure == pl.getHeureFin().getHeure()) {
//                                    if (minutes <= pl.getHeureFin().getMinute()) {
//                                        ok = true;
//                                    }
//                                }
//                            }
//                        }
//
//                        if (ok) {
//                            evt.setAutorise(ok);
//                            break;
//                        }
//                    }
//                }
//            }
//        } else {
//            evt.setAutorise(true);
//        }
//        return evt;
//    }
//
//    @Override
//    public void run() {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
//    @Override
//    public void update(Observable o, Object arg) {
//        if (o == this.borneDrv) {
//            Borne borne = this.borneDrv.getBorne();
//            if (arg != null) {
//                if (arg instanceof Badge) {
//                    Badge badge = (Badge) arg;
//                    AttributionService attributionSrv = MetierFactory.getAttributionService();
//                    Attribution attribution;
//                    try {
//                        attribution = attributionSrv.getByBadge(badge);
//                        if (attribution != null & borne != null) {
//                            Evenement evt = this.autoriserAcces(attribution.getPersonne(), borne.getSalle(), new Date());
//
//                            // ajout event dans bdd
//                            EvenementService evenementSrv = MetierFactory.getEvenementService();
//                            evenementSrv.add(evt);
//
//                            this.borneDrv.ouvrirPorte(borne, evt.isAutorise());
//                        } else {
//                            if (borne == null) {
//                                System.out.println("Borne inconnue");
//                            }
//                            
//                            if (attribution == null) {
//                                System.out.println("Badge non attribué");
//                            }
//                        }
//
//                    } catch (Exception ex) {
//                        System.out.println(ex.getMessage());
//                        Logger
//                                .getLogger(AppControleAccesImpl.class
//                                        .getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            } else {
//                System.out.println("Badge non attribué");
//                try {
//                    // for test
//                    Borne b = new Borne();
//                    b.setId(3);
//                    this.borneDrv.ouvrirPorte(b, true);
//                } catch (Exception ex) {
//                    Logger.getLogger(AppControleAccesImpl.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
