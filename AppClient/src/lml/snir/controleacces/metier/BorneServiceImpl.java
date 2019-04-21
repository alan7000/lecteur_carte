package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.sort.ComparatorByIdBorne;
import lml.snir.controleacces.metier.sort.Sort;

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
        super.setPath("getBySalle/" + salle.getId());
        return super.getEntity();
    }

    @Override
    public Borne add(Borne t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Borne t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Borne t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Borne getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Borne> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Borne> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public Borne[] sort() throws Exception {
        Borne[] bornes = this.getAll().toArray(new Borne[0]);

        ComparatorByIdBorne cmp = new ComparatorByIdBorne();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(bornes, cmp);
        return bornes;
    }

}
