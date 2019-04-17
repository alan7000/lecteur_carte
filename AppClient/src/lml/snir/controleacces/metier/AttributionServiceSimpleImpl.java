package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.sort.ComparatorByAge;
import lml.snir.controleacces.metier.sort.Sort;

public class AttributionServiceSimpleImpl extends ClientRest<Attribution> implements AttributionService {

    AttributionServiceSimpleImpl() {
        super.init("AttributionService", new RestServerLocalConfiguration());
    }

    @Override
    public Attribution getByBadge(Badge badge) throws Exception {
        super.setPath("getByBadge/" + badge.getId());
        return super.getEntity();
    }

    @Override
    public Attribution getByPersonne(Personne personne) throws Exception {
        super.setPath("getByPersonne/" + personne.getId());
        return super.getEntity();
    }

    @Override
    public Boolean isBadgeAttribue(Personne personne) throws Exception {
        super.setPath("badgeAttribuePersonne/" + personne.getId());
        return super.equals(this);
    }

    @Override
    public Boolean isBadgeAttribue(Badge badge) throws Exception {
        super.setPath("badgeAttribueBadge/" + badge.getId());
        return super.equals(this);
    }

    @Override
    public Attribution add(Attribution t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Attribution t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Attribution t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Attribution getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Attribution> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Attribution> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    public Attribution[] sort() throws Exception {
        Attribution[] attributions = this.getAll().toArray(new Attribution[0]);

        //Arrays.sort(personnes);     
        ComparatorByAge cmp = new ComparatorByAge();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(attributions, cmp);

        return attributions;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
