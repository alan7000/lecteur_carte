package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.Autorisation;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.entity.TimeSlot;
import lml.snir.controleacces.metier.sort.ComparatorByIdAutorisation;
import lml.snir.controleacces.metier.sort.Sort;
import lml.snir.controleacces.physique.data.AutorisationDataService;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;

class AutorisationServiceImpl implements AutorisationService {

    private final AutorisationDataService autorisationSrv = PhysiqueDataFactory.getAutorisationDataService();

    @Override
    public Autorisation add(Autorisation authorisation) throws Exception {
        return this.autorisationSrv.add(authorisation);
    }

    @Override
    public void remove(Autorisation authorisation) throws Exception {
        this.autorisationSrv.remove(authorisation);
    }

    @Override
    public void update(Autorisation authorisation) throws Exception {
        this.autorisationSrv.update(authorisation);
    }

    @Override
    public List<Autorisation> getAll(int debut, int count) throws Exception {
        return this.autorisationSrv.getAll(debut, count);
    }

    @Override
    public List<Autorisation> getBySalle(Salle salle) throws Exception {
        return this.autorisationSrv.getBySalle(salle);
    }

    @Override
    public List<Autorisation> getByPersonne(Personne personne) throws Exception {
        return this.autorisationSrv.getByPersonne(personne);
    }

    @Override
    public List<Autorisation> getByPeronneEtSalle(Personne personne, Salle salle) throws Exception {
        return this.autorisationSrv.getByPeronneEtSalle(personne, salle);
    }

    @Override
    public Autorisation getById(Long id) throws Exception {
        return this.autorisationSrv.getById(id);
    }

    @Override
    public long getCount() throws Exception {
        return this.autorisationSrv.getCount();
    }

    @Override
    public List<Autorisation> getAll() throws Exception {
        return this.autorisationSrv.getAll();
    }

    @Override
    public List<Autorisation> getByPlageHoraire(TimeSlot plageHoraire) throws Exception {
        return this.autorisationSrv.getByPlageHoraire(plageHoraire);
    }

    public Autorisation[] sort() throws Exception {
        Autorisation[] autorisations = this.getAll().toArray(new Autorisation[0]);

        ComparatorByIdAutorisation cmp = new ComparatorByIdAutorisation();
        Sort trieuse = MetierFactory.getSortService();
        trieuse.sort(autorisations, cmp);
        return autorisations;
    }
}
