package lml.snir.controleacces.metier;

import java.util.List;
import lml.snir.controleacces.metier.entity.Administrateur;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.physique.data.PersonneDataService;
import lml.snir.controleacces.physique.data.PhysiqueDataFactory;

class PersonneServiceImpl implements PersonneService {

    private final PersonneDataService personneSrv = PhysiqueDataFactory.getPersonneDataService();

    @Override
    public Personne add(Personne personne) throws Exception {
        // check if login ok for admin
        if (personne instanceof Administrateur) {
            Administrateur admin = (Administrateur) personne;
            if (this.getByLogin(admin.getLogin()) != null) {
                throw new Exception("Login déjà attribué");
            }
            
            //if (admin.getMdp())
        }
        return this.personneSrv.add(personne);
    }

    @Override
    public void remove(Personne personne) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.personneSrv.remove(personne);
    }

    @Override
    public void update(Personne personne) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet.");
        this.personneSrv.update(personne);
    }

    @Override
    public Personne getById(Long id) throws Exception {
        return this.personneSrv.getById(id);
    }

    @Override
    public List<Personne> getAll(int debut, int count) throws Exception {
        return this.personneSrv.getAll(debut, count);
    }

    @Override
    public Administrateur getByLogin(String login) throws Exception {
        return this.personneSrv.getByLogin(login);
    }

    @Override
    public List<Personne> getByNom(String nom) throws Exception {
        return this.personneSrv.getByNom(nom);
    }

    @Override
    public long getCount() throws Exception {
        return this.personneSrv.getCount();
    }

    @Override
    public List<Personne> getAll() throws Exception {
        return this.personneSrv.getAll();
    }   
}
