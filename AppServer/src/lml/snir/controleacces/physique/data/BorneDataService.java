package lml.snir.controleacces.physique.data;

import lml.persistence.CrudService;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author fanou
 */
public interface BorneDataService extends CrudService<Borne> {
    public Borne getBySalle(Salle salle) throws Exception;
}
