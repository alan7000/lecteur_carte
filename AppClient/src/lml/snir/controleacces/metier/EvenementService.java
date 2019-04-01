package lml.snir.controleacces.metier;

import java.util.Date;
import java.util.List;
import lml.persistence.CrudService;
import lml.snir.controleacces.metier.entity.Evenement;
import lml.snir.controleacces.metier.entity.Salle;

public interface EvenementService extends CrudService<Evenement> {

    public List<Evenement> getByJour(Date jour) throws Exception;

    public List<Evenement> getBySalle(Salle salle) throws Exception;
}
