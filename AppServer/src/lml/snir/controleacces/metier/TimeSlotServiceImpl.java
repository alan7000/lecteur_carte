/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.TimeSlot;

/**
 *
 * @author alan
 */
public class TimeSlotServiceImpl implements TimeSlotService {
    private final TimeSlotService timeSlotDataSrv = MetierFactory.getTimeSlotService();

    @Override
    public TimeSlot add(TimeSlot t) throws Exception {
        return this.timeSlotDataSrv.add(t);
    }

    @Override
    public void remove(TimeSlot t) throws Exception {
        this.timeSlotDataSrv.remove(t);
    }

    @Override
    public void update(TimeSlot t) throws Exception {
        this.timeSlotDataSrv.update(t);
    }

    @Override
    public TimeSlot getById(Long l) throws Exception {
        return this.timeSlotDataSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.timeSlotDataSrv.getCount();
    }

    @Override
    public List<TimeSlot> getAll() throws Exception {
        return this.timeSlotDataSrv.getAll();
    }

    @Override
    public List<TimeSlot> getAll(int i, int i1) throws Exception {
        return this.timeSlotDataSrv.getAll(i, i1);
    }
    
}
