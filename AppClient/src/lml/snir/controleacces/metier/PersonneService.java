package lml.snir.controleacces.metier;

import java.util.List;
import lml.persistence.CrudService;
import lml.snir.controleacces.metier.entity.Administrateur;
import lml.snir.controleacces.metier.entity.Personne;

public interface PersonneService extends CrudService<Personne> {

    public Administrateur getByLogin(String login) throws Exception;

    public List<Personne> getByNom(String nom) throws Exception;

    public Personne[] sort() throws Exception;
}
