package lml.snir.controleacces.physique.data;

import java.sql.ResultSet;
import lml.persistence.jdbc.AbstracCrudServiceJDBC;
import lml.snir.controleacces.metier.entity.Day;
import lml.snir.controleacces.metier.entity.TimeSlot;

/**
 *
 * @author fanou
 */
final class TimeSlotDataServiceJDBCImpl extends AbstracCrudServiceJDBC<TimeSlot> implements TimeSlotDataService {

    TimeSlotDataServiceJDBCImpl() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS `" + super.getEntityName() + "` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `beginDay` varchar(10) NOT NULL,\n"
                    + "  `beginHour` tinyint(3) UNSIGNED NOT NULL,\n"
                    + "  `beginMinutes` tinyint(3) UNSIGNED NOT NULL,\n"
                    + "  `endDay` varchar(10) NOT NULL,\n"
                    + "  `endHour` tinyint(3) UNSIGNED NOT NULL,\n"
                    + "  `endMinutes` tinyint(3) UNSIGNED NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;";
            super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("TimeSlotDataServiceJDBCImpl() : " + ex);
        }
    }

    @Override
    protected TimeSlot createEntity(ResultSet rs) throws Exception {
        TimeSlot timeSlot;

        long id = rs.getLong("id");
        String beginDayStr = rs.getString("beginDay");
        String endDayStr = rs.getString("endDay");
        int beginHour = rs.getByte("beginHour");
        int endHour = rs.getByte("endHour");
        int beginMinutes = rs.getByte("beginMinutes");
        int endMinutes = rs.getByte("endMinutes");
        Day beginDay = Day.valueOf(beginDayStr);
        Day endDay = Day.valueOf(endDayStr);

        timeSlot = new TimeSlot(beginDay, beginHour, beginMinutes, endDay, endHour, endMinutes);
        timeSlot.setId(id);

        return timeSlot;
    }

    @Override
    public TimeSlot add(TimeSlot timeSlot) throws Exception {
        String query = "INSERT INTO " + super.getEntityName() + " (beginDay,endDay,beginHour,endHour,beginMinutes,endMinutes) VALUES ('"
                + timeSlot.getBeginDay() + "','"
                + timeSlot.getEndDay() + "','"
                + timeSlot.getBeginHour() + "','"
                + timeSlot.getEndHour() + "','"
                + timeSlot.getBeginMinutes() + "','"
                + timeSlot.getEndMinutes() + "')";

        timeSlot.setId(super.executeAdd(query));

        return timeSlot;
    }

    @Override
    public void remove(TimeSlot timeSlot) throws Exception {
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + timeSlot.getId() + "'";
        super.executeQuery(query);
    }

    @Override
    public void update(TimeSlot timeSlot) throws Exception {
        String query = "UPDATE " + super.getEntityName() + " SET beginDay = '"
                + timeSlot.getBeginDay() + "', endDay = '"
                + timeSlot.getEndDay() + "', beginHour = '"
                + timeSlot.getBeginHour() + "', endHour = '"
                + timeSlot.getEndHour() + "', beginMinutes = '"
                + timeSlot.getBeginMinutes() + "', endMinutes = '"
                + timeSlot.getEndMinutes() + "' WHERE id = '" + timeSlot.getId() + "'";

        super.executeQuery(query);
    }

}
