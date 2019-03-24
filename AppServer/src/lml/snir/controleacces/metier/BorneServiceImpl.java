package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.physique.data.BorneDataService;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;

/**
 *
 * @author fanou
 */
public class BorneServiceImpl implements BorneService {

    private final BorneDataService borneDataSrv = PhysiqueDataFactory.getBorneDataService();

    @Override
    public Borne getBySalle(Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.borneDataSrv.getBySalle(salle);
    }

    @Override
    public Borne add(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.borneDataSrv.add(t);
    }

    @Override
    public void remove(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.borneDataSrv.remove(t);
    }

    @Override
    public void update(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.borneDataSrv.update(t);
    }

    @Override
    public Borne getById(Long l) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.borneDataSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.borneDataSrv.getCount();
    }

    @Override
    public List<Borne> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.borneDataSrv.getAll();
    }

    @Override
    public List<Borne> getAll(int i, int i1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.borneDataSrv.getAll(i, i1);
    }

}
