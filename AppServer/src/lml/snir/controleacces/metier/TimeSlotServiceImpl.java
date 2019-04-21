/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.TimeSlot;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;
import lml.snir.controleacces.physique.data.TimeSlotDataService;

/**
 *
 * @author jupiter
 */
class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotDataService timeSlotService = PhysiqueDataFactory.getTimeSlotService();

    @Override
    public TimeSlot add(TimeSlot t) throws Exception {
        return timeSlotService.add(t);
    }

    @Override
    public void remove(TimeSlot t) throws Exception {
        timeSlotService.remove(t);
    }

    @Override
    public void update(TimeSlot t) throws Exception {
        timeSlotService.update(t);
    }

    @Override
    public TimeSlot getById(Long l) throws Exception {
        return timeSlotService.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return timeSlotService.getCount();
    }

    @Override
    public List<TimeSlot> getAll() throws Exception {
        return timeSlotService.getAll();
    }

    @Override
    public List<TimeSlot> getAll(int i, int i1) throws Exception {
        return timeSlotService.getAll(i, i1);
    }

}
