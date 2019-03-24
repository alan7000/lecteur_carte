package lml.snir.controleacces.client;

import java.util.List;
import lml.snir.controleacces.metier.AttributionService;
import lml.snir.controleacces.metier.BadgeService;
import lml.snir.controleacces.metier.BorneService;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.PersonneService;
import lml.snir.controleacces.metier.SalleService;
import lml.snir.controleacces.metier.entity.Administrateur;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Day;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.entity.TimeSlot;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;
import lml.snir.controleacces.physique.data.TimeSlotDataService;

/**
 *
 * @author fanou
 */
public class AppServer {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        /*
        Appel service
         */

        AttributionService attributionSrv = MetierFactory.getAttributionService();
        PersonneService personneSrv = MetierFactory.getPersonneService();
        BadgeService badgeSrv = MetierFactory.getBadgeService();
        SalleService salleSrv = MetierFactory.getSalleService();
        TimeSlotDataService timeSlotSrv = PhysiqueDataFactory.getTimeSlotService();
        BorneService borneSrv = MetierFactory.getBorneService();

        /*
        Création objet
         */
        Personne pers;
        Administrateur admin;
        Personne p = new Administrateur();
        Badge b = new Badge();
        Salle salle = new Salle();
        Borne borne = new Borne();

        /*
         Add personne (admin)
         */
//        pers = new Administrateur("ALONSO", "Stéphane");
//        admin = (Administrateur) pers;
//        admin.setLogin("fanou");
//        admin.setMdp("secret");
//        System.out.println(pers);
//        personneSrv.add(pers);
//        pers = new Personne("Flambard", "Alan");
//        personneSrv.add(pers);

        /*
         Remove personne
         */
//        pers.setId(3);
//        personneSrv.remove(pers);
//        System.out.println(pers);

        /*
         Update personne
         */
//        p.setNom("TOTO");
//        p.setPrenom("Salut");
//        Administrateur a = (Administrateur) p;
//        a.setLogin("fanou");
//        a.setMdp("secret");
//        p.setId(2);
//        personneSrv.update(p);
        /*
         getByLogin
         */
        System.out.println("get by login" + personneSrv.getByLogin("fanou"));

        /*
         getByNom
         */
        System.out.println("get by nom" + personneSrv.getByNom("ALONSO"));

        /*
         getAll
         */
        System.out.println("get All " + personneSrv.getAll());

        /*
         getCount
         */
        System.out.println("getCount " + personneSrv.getCount());

        /*
         Add Badge
         */
//        b.setContenu("salut");
//        badgeSrv.add(b);
//        System.out.println(b);

        /*
         Remove badge
         */
//        b.setId(2);
//        badgeSrv.remove(b);
//        System.out.println(b);

        /*
         getBadgeContenu
         */
        System.out.println("getByContenu " + badgeSrv.getByContenu("salut"));

        /*
         Badge getAll
         */
        System.out.println("getAll Badge " + badgeSrv.getAll());

        /*
         Badge getCount
         */
        System.out.println("getCount " + badgeSrv.getCount());

        /*
         Salle Add
         */
//        salle.setId(12);
//        salle.setProtege(false);
//        salleSrv.add(salle);

        /*
         Salle remove
         */
//        salle.setId(12);
//        salleSrv.remove(salle);

        /*
         Salle getAll
         */
        System.out.println("getAll Salle " + salleSrv.getAll());

        /*
         Salle getByProtege
         */
        System.out.println("getByProtege " + salleSrv.getByProtege(true));

        List<Salle> salles = salleSrv.getByProtege(false);
        for (Salle s : salles) {
            System.out.println(s);
        }

        /*
         Salle getById
         */
        System.out.println("getById ");

        /*
         Borne Add
       
         */
//        salle.setId(12);
//        borne.setSalle(salle);
//        borneSrv.add(borne);

//        List<Personne> personnes = personneSrv.getAll();
//        List<Badge> badges = badgeSrv.getAll();
//        for (Personne p : personnes) {
//            System.out.println(p);
//            if (p instanceof Administrateur) {
//                Administrateur a = (Administrateur)p;
//                if (a.getLogin().equals("fanou")) {
//                    System.out.println(a.isValid("secret"));
//                    for (Badge b : badges) {
//                        if (attributionSrv.getByBadge(b) == null) {
//                            System.out.println("badge : " + b + " non attribué");
//                            if (attributionSrv.getByPersonne(p) == null) {
//                                System.out.println("personne : " + p + " sans badge");
//                                Attribution attr = new Attribution();
//                                attr.setBadge(b);
//                                attr.setPersonne(p);
//                                attributionSrv.add(attr);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        
//        List<Attribution> attributions = attributionSrv.getAll();
//        for (Attribution attr : attributions) {
//            System.out.println(attr);
//        }
//        List<Salle> salles = salleSrv.getAll();
//        for (Salle s : salles) {
//            System.out.println(s);
//        }
//        TimeSlot timeSlot = new TimeSlot(Day.Monday, 10, 30, Day.Monday, 12, 30);
//        timeSlotSrv.add(timeSlot);
//        timeSlot = new TimeSlot(Day.Monday, 14, 00, Day.Monday, 18, 00);
//        timeSlotSrv.add(timeSlot);
//        timeSlot = new TimeSlot(Day.Thursday, 8, 30, Day.Friday, 17, 00);
//        timeSlotSrv.add(timeSlot);
        List<TimeSlot> timeSlots = timeSlotSrv.getAll();
        for (TimeSlot t : timeSlots) {
            System.out.println(t);
        }
    }

}
