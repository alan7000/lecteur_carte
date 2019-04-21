package lml.snir.controleacces.metier;

import java.util.List;
import lml.persistence.CrudService;
import lml.snir.controleacces.metier.entity.Salle;

public interface SalleService extends CrudService<Salle> {

    public List<Salle> getByProtege(boolean protege) throws Exception;

    public List<Salle> getNumero(long numero) throws Exception;

    public Salle[] sort() throws Exception;
}
