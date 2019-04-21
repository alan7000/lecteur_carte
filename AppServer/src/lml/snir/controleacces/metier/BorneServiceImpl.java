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
        return this.borneDataSrv.getBySalle(salle);
    }

    @Override
    public Borne add(Borne t) throws Exception {
        return this.borneDataSrv.add(t);
    }

    @Override
    public void remove(Borne t) throws Exception {
        this.borneDataSrv.remove(t);
    }

    @Override
    public void update(Borne t) throws Exception {
        this.borneDataSrv.update(t);
    }

    @Override
    public Borne getById(Long l) throws Exception {
        return this.borneDataSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.borneDataSrv.getCount();
    }

    @Override
    public List<Borne> getAll() throws Exception {
        return this.borneDataSrv.getAll();
    }

    @Override
    public List<Borne> getAll(int i, int i1) throws Exception {
        return this.borneDataSrv.getAll(i, i1);
    }

}
