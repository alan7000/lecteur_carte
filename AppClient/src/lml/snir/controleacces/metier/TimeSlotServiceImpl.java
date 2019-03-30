/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.TimeSlot;

/**
 *
 * @author alan
 */
public class TimeSlotServiceImpl extends ClientRest<TimeSlot> implements TimeSlotService {

    public TimeSlotServiceImpl() {
        super.init("TimeSlotService", new RestServerLocalConfiguration());
    }

    @Override
    public TimeSlot add(TimeSlot t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    return super.addEntity(t);
    }

    @Override
    public void remove(TimeSlot t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    super.removeEntity(t);
    }

    @Override
    public void update(TimeSlot t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    super.updateEntity(t);
    }

    @Override
    public TimeSlot getById(Long l) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("" + l);
    return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("Count");
    return super.getCountEntity();
    }

    @Override
    public List<TimeSlot> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getAll");
    return super.getEntitys();
    }

    @Override
    public List<TimeSlot> getAll(int i, int i1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("" + i + "/" + i1);
    return super.getEntitys();
    }
    
    
}
