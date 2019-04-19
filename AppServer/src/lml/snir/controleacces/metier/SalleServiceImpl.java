package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;
import lml.snir.controleacces.physique.data.SalleDataService;

/**
 *
 * @author fanou
 */
public final class SalleServiceImpl implements SalleService {

    private final SalleDataService salleDataSrv = PhysiqueDataFactory.getSalleDataService();

    @Override
    public List<Salle> getByProtege(boolean protege) throws Exception {
        return this.salleDataSrv.getByProtege(protege);
    }

    @Override
    public Salle add(Salle t) throws Exception {
        return this.salleDataSrv.add(t);
    }

    @Override
    public void remove(Salle t) throws Exception {
        this.salleDataSrv.remove(t);
    }

    @Override
    public void update(Salle t) throws Exception {
        this.salleDataSrv.update(t);
    }

    @Override
    public Salle getById(Long l) throws Exception {
        return this.salleDataSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.salleDataSrv.getCount();
    }

    @Override
    public List<Salle> getAll() throws Exception {
        return this.salleDataSrv.getAll();
    }

    @Override
    public List<Salle> getAll(int i, int i1) throws Exception {
        return this.salleDataSrv.getAll(i, i1);
    }

    @Override
    public List<Salle> getNumero(long numero) throws Exception {
        return this.salleDataSrv.getNumero(numero);
    }

}
