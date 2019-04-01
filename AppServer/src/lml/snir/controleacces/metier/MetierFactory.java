package lml.snir.controleacces.metier;

import lml.snir.controleacces.physique.data.TimeSlotDataService;

public class MetierFactory {

    private static AppControleAcces appControleAcces = null;

    synchronized public static AppControleAcces getAppControleAcces() throws Exception {
        if (appControleAcces == null) {
            appControleAcces = new AppControleAccesImpl();
        }
        return appControleAcces;
    }

    private static final BadgeService badgeService = new BadgeServiceImpl();

    public static BadgeService getBadgeService() {
        return badgeService;
    }

    private static final AttributionService attributionService = new AttributionServiceImpl();

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

    private static final AutorisationRPCService autorisationRPCService = new AutorisationRPCServiceServerJSONImpl();

    public static AutorisationRPCService getAutorisationRPCService() {
        return autorisationRPCService;
    }

    private static final BorneService borneService = new BorneServiceImpl();

    public static BorneService getBorneService() {
        return borneService;
    }

    private static TimeSlotService timeSlotService = new TimeSlotServiceImpl();
    public static TimeSlotService getTimeSlotService(){
        return timeSlotService;
    }
    private MetierFactory() {
    }

}
