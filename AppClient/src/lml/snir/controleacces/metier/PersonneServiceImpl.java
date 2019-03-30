package lml.snir.controleacces.metier;

import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Administrateur;
import lml.snir.controleacces.metier.entity.Personne;
//import lml.snir.controleacces.physique.data.PersonneDataService;
//import lml.snir.controleacces.physique.data.PhysiqueDataFactory;

class PersonneServiceImpl extends ClientRest<Personne> implements PersonneService {

    public PersonneServiceImpl() {
        super.init("PersonneService", new RestServerLocalConfiguration());
    }

    @Override
    public Administrateur getByLogin(String login) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getByUtilisateur/" + login);
    return (Administrateur) super.getEntity();
    }

    @Override
    public List<Personne> getByNom(String nom) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("getByNom/" + nom);
    return super.getEntitys();
    }

    @Override
    public Personne add(Personne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    return super.addEntity(t);
    }

    @Override
    public void remove(Personne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    super.removeEntity(t);
    }

    @Override
    public void update(Personne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    super.updateEntity(t);
    }

    @Override
    public Personne getById(Long l) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("/" + l);
    return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("Count");
    return super.getCountEntity();
    }

    @Override
    public List<Personne> getAll() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("");
    return super.getEntitys();
    }

    @Override
    public List<Personne> getAll(int i, int i1) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    super.setPath("" + i + "/" + i1);
    return super.getEntitys();
    }

    
    
}
