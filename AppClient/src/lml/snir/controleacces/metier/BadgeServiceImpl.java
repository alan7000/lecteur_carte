package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Badge;

class BadgeServiceImpl extends ClientRest<Badge> implements BadgeService {

    @Override
    public Badge getByContenu(String contenu) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getByContenu/" + contenu);
    return super.getEntity();
    }

    @Override
    public Badge add(Badge t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    return super.addEntity(t);
    }

    @Override
    public void remove(Badge t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    super.removeEntity(t);
    }

    @Override
    public void update(Badge t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    super.updateEntity(t);
    }

    @Override
    public Badge getById(Long l) throws Exception {
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
    public List<Badge> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getAll");
    return super.getEntitys();
    }

    @Override
    public List<Badge> getAll(int i, int i1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("" + i + "/" + i1);
    return super.getEntitys();
    }
    
    
}
