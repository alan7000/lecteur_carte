package lml.snir.controleacces.metier;

import lml.snir.controleacces.metier.entity.TimeSlot;
import lml.snir.controleacces.metier.sort.InsertionOptimisedSort;
import lml.snir.controleacces.metier.sort.Sort;

public class MetierFactory {

    private static final BadgeService badgeService = new BadgeServiceImpl();

    public static BadgeService getBadgeService() {
        return badgeService;
    }

    private static final AttributionService attributionService = new AttributionServiceSimpleImpl();

    public static AttributionService getAttributionService() {
        return attributionService;
    }

    private static final AutorisationService autorisation = new AutorisationServiceImpl();

    public static AutorisationService getAutorisationService() {
        return autorisation;
    }

    private static final EvenementService evenementService = new EvenementServiceImpl();

    public static EvenementService getEvenementService() {
        return evenementService;
    }

    private static final PersonneService personneService = new PersonneServiceImpl();

    public static PersonneService getPersonneService() {
        return personneService;
    }

    private static final SalleService salleService = new SalleServiceImpl();

    public static SalleService getSalleService() {
        return salleService;
    }

    private static final BorneService borneService = new BorneServiceImpl();

    public static BorneService getBorneService() {
        return borneService;
    }

    private static TimeSlotServiceImpl timeSlotService = new TimeSlotServiceImpl();

    public static TimeSlotServiceImpl getTimeSlotService() {
        return timeSlotService;
    }

    private static final Sort sortSrv = new InsertionOptimisedSort();

    public static Sort getSortSerivce() {
        return sortSrv;
    }

    private MetierFactory() {
    }

}
