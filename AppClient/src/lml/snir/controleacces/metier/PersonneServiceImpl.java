package lml.snir.controleacces.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Administrateur;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.sort.ComparatorByAge;
import lml.snir.controleacces.metier.sort.Sort;

class PersonneServiceImpl extends ClientRest<Personne> implements PersonneService {

    public PersonneServiceImpl() {
        super.init("PersonneService", new RestServerLocalConfiguration());

        List<Class> classes = new ArrayList<>();
        classes.add(Administrateur.class);
        super.polymorphicInit(classes);
    }

    @Override
    public Administrateur getByLogin(String login) throws Exception {
        super.setPath("getByUtilisateur/" + login);
        return (Administrateur) super.getEntity();
    }

    @Override
    public List<Personne> getByNom(String nom) throws Exception {
        super.setPath("getByNom/" + nom);
        return super.getEntitys();
    }

    @Override
    public Personne add(Personne t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Personne t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Personne t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Personne getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Personne> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Personne> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

    @Override
    public Personne[] sort() throws Exception {
        Personne[] personnes = this.getAll().toArray(new Personne[0]);

        //Arrays.sort(personnes);     
        ComparatorByAge cmp = new ComparatorByAge();
        Sort trieuse = MetierFactory.getSortSerivce();
        trieuse.sort(personnes, cmp);

        return personnes;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
