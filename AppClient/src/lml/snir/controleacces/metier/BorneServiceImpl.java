package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author fanou
 */
public class BorneServiceImpl extends ClientRest<Borne> implements BorneService {

    public BorneServiceImpl() {
        super.init("BorneService", new RestServerLocalConfiguration());
    }
    
    @Override
    public Borne getBySalle(Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getBySalle/" + salle.getId());
    return super.getEntity();
    }

    @Override
    public Borne add(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    return super.addEntity(t);
    }

    @Override
    public void remove(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    super.removeEntity(t);
    }

    @Override
    public void update(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    super.updateEntity(t);
    }

    @Override
    public Borne getById(Long l) throws Exception {
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
    public List<Borne> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    return super.getEntitys();
    }

    @Override
    public List<Borne> getAll(int i, int i1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("" + i + "/" + i1);
    return super.getEntitys();
    }

    

}
