package lml.snir.controleacces.client;

import java.util.List;
import lml.snir.controleacces.metier.AttributionService;
import lml.snir.controleacces.metier.BadgeService;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.PersonneService;
import lml.snir.controleacces.metier.SalleService;
import lml.snir.controleacces.metier.entity.Administrateur;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Badge;
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
        AttributionService attributionSrv = MetierFactory.getAttributionService();
        PersonneService personneSrv = MetierFactory.getPersonneService();
        BadgeService badgeSrv = MetierFactory.getBadgeService();
        SalleService salleSrv = MetierFactory.getSalleService();
        TimeSlotDataService timeSlotSrv = PhysiqueDataFactory.getTimeSlotService();
        
//        Personne p = new Administrateur();
//        p.setNom("ALONSO");
//        p.setPrenom("Stéphane");
//        Administrateur a = (Administrateur)p;
//        a.setLogin("fanou");
//        a.setMdp("secret");
//        p = personneSrv.add(p);
//        System.out.println(p);
        
        
        List<Personne> personnes = personneSrv.getAll();
        List<Badge> badges = badgeSrv.getAll();
        for (Personne p : personnes) {
            System.out.println(p);
            if (p instanceof Administrateur) {
                Administrateur a = (Administrateur)p;
                if (a.getLogin().equals("fanou")) {
                    System.out.println(a.isValid("secret"));
                    for (Badge b : badges) {
                        if (attributionSrv.getByBadge(b) == null) {
                            System.out.println("badge : " + b + " non attribué");
                            if (attributionSrv.getByPersonne(p) == null) {
                                System.out.println("personne : " + p + " sans badge");
                                Attribution attr = new Attribution();
                                attr.setBadge(b);
                                attr.setPersonne(p);
                                attributionSrv.add(attr);
                            }
                        }
                    }
                }
            }
        }
        
        List<Attribution> attributions = attributionSrv.getAll();
        for (Attribution attr : attributions) {
            System.out.println(attr);
        }
        
        List<Salle> salles = salleSrv.getAll();
        for (Salle s : salles) {
            System.out.println(s);
        }
        
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
