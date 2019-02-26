package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author fanou
 */
public class BorneServiceImpl implements BorneService {

    @Override
    public Borne getBySalle(Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return this.getBySalle(salle);
    }

    @Override
    public Borne add(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return this.add(t);
    }

    @Override
    public void remove(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.remove(t);
    }

    @Override
    public void update(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.update(t);
    }

    @Override
    public Borne getById(Long l) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return this.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return this.getCount();
    }

    @Override
    public List<Borne> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return this.getAll();
    }

    @Override
    public List<Borne> getAll(int i, int i1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return this.getAll(i, i1);
    }
    
}
