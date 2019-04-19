package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.sort.ComparatorByNumeroSalle;
import lml.snir.controleacces.metier.sort.Sort;

/**
 *
 * @author fanou
 */
public final class SalleServiceImpl extends ClientRest<Salle> implements SalleService {

    public SalleServiceImpl() {
        super.init("SalleService", new RestServerLocalConfiguration());
    }

    @Override
    public List<Salle> getByProtege(boolean protege) throws Exception {
        super.setPath("getByProtege/" + protege);
        return super.getEntitys();
    }

    @Override
    public Salle add(Salle t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Salle t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Salle t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Salle getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Salle> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Salle> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public List<Salle> getNumero(long numero) throws Exception {
        super.setPath("Numero" + numero);
        return super.getEntitys();
    }

    @Override
    public Salle[] sort() throws Exception {
        Salle[] salles = this.getAll().toArray(new Salle[0]);
        
        ComparatorByNumeroSalle cmp = new ComparatorByNumeroSalle();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(salles, cmp);
        return salles;
    }

}
