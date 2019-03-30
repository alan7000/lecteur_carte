package lml.snir.controleacces.metier;

import lml.persistence.CrudService;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.entity.Personne;

public interface AttributionService extends CrudService<Attribution> {

    public Attribution getByBadge(Badge badge) throws Exception;

    public Attribution getByPersonne(Personne personne) throws Exception;

    public Boolean isBadgeAttribue(Personne personne) throws Exception;

    public Boolean isBadgeAttribue(Badge badge) throws Exception;
}
