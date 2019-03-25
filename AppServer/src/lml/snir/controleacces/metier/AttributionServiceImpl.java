package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.physique.data.AttributionDataService;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;

class AttributionServiceImpl implements AttributionService {

    private final AttributionDataService attributionSrv = PhysiqueDataFactory.getAttributionDataService();

    @Override
    public Attribution add(Attribution attribution) throws Exception {
        return this.attributionSrv.add(attribution);
    }

    @Override
    public void remove(Attribution attribution) throws Exception {
        this.attributionSrv.remove(attribution);
    }

    @Override
    public void update(Attribution attribution) throws Exception {
        this.attributionSrv.update(attribution);
    }

    @Override
    public List<Attribution> getAll(int debut, int count) throws Exception {
        return this.attributionSrv.getAll(debut, count);
    }

    @Override
    public Attribution getByBadge(Badge badge) throws Exception {
        return this.attributionSrv.getByBadge(badge);
    }

    @Override
    public Attribution getByPersonne(Personne personne) throws Exception {
        return this.attributionSrv.getByPersonne(personne);
    }

    @Override
    public Attribution getById(Long l) throws Exception {
        return this.attributionSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.attributionSrv.getCount();
    }

    @Override
    public List<Attribution> getAll() throws Exception {
        return this.attributionSrv.getAll();
    }

    @Override
    public Boolean isBadgeAttribue(Personne personne) throws Exception {
        return this.attributionSrv.isBadgeAttribue(personne);
    }

    @Override
    public Boolean isBadgeAttribue(Badge badge) throws Exception {
        return this.attributionSrv.isBadgeAttribue(badge);
    }
    
}
