package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Autorisation;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.entity.TimeSlot;
//import lml.snir.controleacces.physique.data.AutorisationDataService;
//import lml.snir.controleacces.physique.data.PhysiqueDataFactory;

class AutorisationServiceImpl extends ClientRest<Autorisation>implements AutorisationService {

    @Override
    public List<Autorisation> getBySalle(Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getBySalle/" + salle.getId());
        return super.getEntitys();
    }

    @Override
    public List<Autorisation> getByPersonne(Personne personne) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getByPersonne/" + personne.getId());
        return super.getEntitys();
    }

    @Override
    public List<Autorisation> getByPlageHoraire(TimeSlot plageHoraire) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getByPlageHoraire/" + plageHoraire.getId());
        return super.getEntitys();
    }

    @Override
    public List<Autorisation> getByPeronneEtSalle(Personne personne, Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getByPersonneEtSalle/" + personne.getId() + "/" + salle.getId());
        return super.getEntitys();
    }

    @Override
    public Autorisation add(Autorisation t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Autorisation t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Autorisation t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Autorisation getById(Long l) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Autorisation> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getAll");
        return super.getEntitys();
    }

    @Override
    public List<Autorisation> getAll(int i, int i1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    
}
