package lml.snir.controleacces.metier;

import java.util.Date;
import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Day;
import lml.snir.controleacces.metier.entity.Evenement;
import lml.snir.controleacces.metier.entity.Salle;

class EvenementServiceImpl extends ClientRest<Evenement> implements EvenementService {

    public EvenementServiceImpl() {
        super.init("EvenementService", new RestServerLocalConfiguration());
    }

    @Override
    public List<Evenement> getByJour(Date jour) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.setPath("getByJour/" + jour); //Voir avec le prof
        return super.getEntitys();
    }

    @Override
    public List<Evenement> getBySalle(Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.setPath("getBySalle/" + salle.getId());
        return super.getEntitys();
    }

    @Override
    public Evenement add(Evenement t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Evenement t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Evenement t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Evenement getById(Long l) throws Exception {
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
    public List<Evenement> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Evenement> getAll(int i, int i1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

}
