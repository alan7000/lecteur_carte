package lml.snir.controleacces.metier;

import lml.persistence.CrudService;
import lml.snir.controleacces.metier.entity.Badge;

public interface BadgeService extends CrudService<Badge> {

    public Badge getByContenu(String contenu) throws Exception;
    
    public Badge[] sort() throws Exception;
}
