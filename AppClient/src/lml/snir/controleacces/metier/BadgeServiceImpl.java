package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.sort.ComparatorByIdBadge;
import lml.snir.controleacces.metier.sort.Sort;

class BadgeServiceImpl extends ClientRest<Badge> implements BadgeService {

    public BadgeServiceImpl() {
        super.init("BadgeService", new RestServerLocalConfiguration());
    }

    @Override
    public Badge getByContenu(String contenu) throws Exception {
        super.setPath("getByContenu/" + contenu);
        return super.getEntity();
    }

    @Override
    public Badge add(Badge t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Badge t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Badge t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Badge getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Badge> getAll() throws Exception {
        super.setPath("getAll");
        return super.getEntitys();
    }

    @Override
    public List<Badge> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public Badge[] sort() throws Exception {
        Badge[] badges = this.getAll().toArray(new Badge[0]);

        ComparatorByIdBadge cmp = new ComparatorByIdBadge();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(badges, cmp);
        return badges;
    }
}
