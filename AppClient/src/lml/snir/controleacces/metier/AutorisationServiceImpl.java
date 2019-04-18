package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Autorisation;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.entity.TimeSlot;
import lml.snir.controleacces.metier.sort.ComparatorByIdAutorisation;
import lml.snir.controleacces.metier.sort.Sort;

class AutorisationServiceImpl extends ClientRest<Autorisation> implements AutorisationService {

    public AutorisationServiceImpl() {
        super.init("AutorisationService", new RestServerLocalConfiguration());
    }

    
    
    @Override
    public List<Autorisation> getBySalle(Salle salle) throws Exception {
        super.setPath("getBySalle/" + salle.getId());
        return super.getEntitys();
    }

    @Override
    public List<Autorisation> getByPersonne(Personne personne) throws Exception {
        super.setPath("getByPersonne/" + personne.getId());
        return super.getEntitys();
    }

    @Override
    public List<Autorisation> getByPlageHoraire(TimeSlot plageHoraire) throws Exception {
        super.setPath("getByPlageHoraire/" + plageHoraire.getId());
        return super.getEntitys();
    }

    @Override
    public List<Autorisation> getByPeronneEtSalle(Personne personne, Salle salle) throws Exception {
        super.setPath("getByPersonneEtSalle/" + personne.getId() + "/" + salle.getId());
        return super.getEntitys();
    }

    @Override
    public Autorisation add(Autorisation t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Autorisation t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Autorisation t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Autorisation getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Autorisation> getAll() throws Exception {
        super.setPath("getAll");
        return super.getEntitys();
    }

    @Override
    public List<Autorisation> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public Autorisation[] sort() throws Exception {
        Autorisation[] autorisations = this.getAll().toArray(new Autorisation[0]);
        
        ComparatorByIdAutorisation cmp = new ComparatorByIdAutorisation();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(autorisations, cmp);
        return autorisations;
    }
    
}
