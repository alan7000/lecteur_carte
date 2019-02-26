package lml.snir.controleacces.physique.data;

/**
 *
 * @author fanou
 */
public class PhysiqueDataFactory {

    private static final AutorisationDataService autorisationDataService = new AutorisationDataServiceJDBCImpl();
    public static AutorisationDataService getAutorisationDataService() {
        return autorisationDataService;
    }

    private static final BadgeDataService badgeDataService = new BadgeDataServiceJDBCImpl();
    public static BadgeDataService getBadgeDataService() {
        return badgeDataService;
    }
    
    private static final BorneDataService borneDataService = new BorneDataServiceJDBCImpl();
    public static BorneDataService getBorneDataService() {
        return borneDataService;
    }

    private static final EvenementDataService evenementDataService = new EvenementDataServiceJDBCImpl();
    public static EvenementDataService getEvenementDataService() {
        return evenementDataService;
    }

    private static final PersonneDataService personneDataService = new PersonneDataServiceJDBCImpl();
    public static PersonneDataService getPersonneDataService() {
        return personneDataService;
    }

    private static final TimeSlotDataService timeSlotDataService = new TimeSlotDataServiceJDBCImpl();
    public static TimeSlotDataService getTimeSlotService() {
        return timeSlotDataService;
    }

    private PhysiqueDataFactory() {}
    
    private static final AttributionDataService attributionDataService = new AttributionDataServiceJDBCImpl();
    public static AttributionDataService getAttributionDataService() {
        return attributionDataService;
    }
    
    private static final SalleDataService salleDataService = new SalleDataServiceJDBCImpl();
    public static SalleDataService getSalleDataService() {
        return salleDataService;
    }
    
}
