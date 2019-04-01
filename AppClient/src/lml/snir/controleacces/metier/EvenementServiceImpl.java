package lml.snir.controleacces.metier;

import java.util.Date;
import java.util.List;
import lml.rest.client.ClientRest;
import lml.snir.controleacces.metier.entity.Evenement;
import lml.snir.controleacces.metier.entity.Salle;

class EvenementServiceImpl extends ClientRest<Evenement> implements EvenementService {

    public EvenementServiceImpl() {
        super.init("EvenementService", new RestServerLocalConfiguration());
    }

    @Override
    public List<Evenement> getByJour(Date jour) throws Exception {
        super.setPath("getByJour/" + jour); //Voir avec le prof
        return super.getEntitys();
    }

    @Override
    public List<Evenement> getBySalle(Salle salle) throws Exception {
        super.setPath("getBySalle/" + salle.getId());
        return super.getEntitys();
    }

    @Override
    public Evenement add(Evenement t) throws Exception {
        super.setPath("");
        return super.addEntity(t);
    }

    @Override
    public void remove(Evenement t) throws Exception {
        super.setPath("");
        super.removeEntity(t);
    }

    @Override
    public void update(Evenement t) throws Exception {
        super.setPath("");
        super.updateEntity(t);
    }

    @Override
    public Evenement getById(Long l) throws Exception {
        super.setPath("" + l);
        return super.getEntity();
    }

    @Override
    public long getCount() throws Exception {
        super.setPath("Count");
        return super.getCountEntity();
    }

    @Override
    public List<Evenement> getAll() throws Exception {
        super.setPath("");
        return super.getEntitys();
    }

    @Override
    public List<Evenement> getAll(int i, int i1) throws Exception {
        super.setPath("" + i + "/" + i1);
        return super.getEntitys();
    }

}
