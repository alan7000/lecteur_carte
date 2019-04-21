package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.physique.data.BadgeDataService;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;

class BadgeServiceImpl implements BadgeService {

    private final BadgeDataService badgeSrv = PhysiqueDataFactory.getBadgeDataService();

    public BadgeServiceImpl() {
    }

    @Override
    public Badge add(Badge badge) throws Exception {
        return this.badgeSrv.add(badge);
    }

    @Override
    public void remove(Badge badge) throws Exception {
        this.badgeSrv.remove(badge);
    }

    @Override
    public void update(Badge badge) throws Exception {
        this.badgeSrv.update(badge);
    }

    @Override
    public List<Badge> getAll(int debut, int count) throws Exception {
        return this.badgeSrv.getAll(debut, count);
    }

    @Override
    public Badge getByContenu(String contenu) throws Exception {
        return this.badgeSrv.getByContenu(contenu);
    }

    @Override
    public Badge getById(Long id) throws Exception {
        return this.badgeSrv.getById(id);
    }

    @Override
    public long getCount() throws Exception {
        return this.badgeSrv.getCount();
    }

    @Override
    public List<Badge> getAll() throws Exception {
        return this.badgeSrv.getAll();
    }
}
