package lml.snir.controleacces.metier;

import java.util.Date;
import java.util.List;
import lml.snir.controleacces.metier.entity.Evenement;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.physique.data.EvenementDataService;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;

class EvenementServiceImpl implements EvenementService {

    private final EvenementDataService evenementSrv = PhysiqueDataFactory.getEvenementDataService();

    @Override
    public Evenement add(Evenement evenement) throws Exception {
        return this.evenementSrv.add(evenement);
    }

    @Override
    public void remove(Evenement evenement) throws Exception {
        this.evenementSrv.remove(evenement);
    }

    @Override
    public void update(Evenement evenement) throws Exception {
        this.evenementSrv.update(evenement);
    }

    @Override
    public List<Evenement> getAll(int debut, int count) throws Exception {
        return this.evenementSrv.getAll(debut, count);
    }

    @Override
    public List<Evenement> getByJour(Date jour) throws Exception {
        return this.evenementSrv.getByJour(jour);
    }

    @Override
    public List<Evenement> getBySalle(Salle salle) throws Exception {
        return this.evenementSrv.getBySalle(salle);
    }

    @Override
    public Evenement getById(Long l) throws Exception {
        return this.evenementSrv.getById(l);
    }

    @Override
    public long getCount() throws Exception {
        return this.evenementSrv.getCount();
    }

    @Override
    public List<Evenement> getAll() throws Exception {
        return this.evenementSrv.getAll();
    }

}
