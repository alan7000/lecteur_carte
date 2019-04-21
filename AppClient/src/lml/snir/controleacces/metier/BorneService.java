package lml.snir.controleacces.metier;

import lml.persistence.CrudService;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;

public interface BorneService extends CrudService<Borne> {

    public Borne getBySalle(Salle salle) throws Exception;

    public Borne[] sort() throws Exception;
}
