package lml.snir.controleacces.physique.data;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lml.persistence.jdbc.AbstracCrudServiceJDBC;
import lml.snir.controleacces.metier.entity.Evenement;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;

final class EvenementDataServiceJDBCImpl extends AbstracCrudServiceJDBC<Evenement> implements EvenementDataService {

    EvenementDataServiceJDBCImpl() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS `" + super.getEntityName() + "` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `idPersonne` int(11) NOT NULL,\n"
                    + "  `idSalle` int(11) NOT NULL,\n"
                    + "  `date` datetime NOT NULL,\n"
                    + "  `autorise` tinyint(1) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";
            super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("EvenementDataServiceJDBCImpl() : " + ex);
        }
    }

    @Override
    protected Evenement createEntity(ResultSet rs) throws Exception {
        Evenement event;

        long id = rs.getLong("id");
        long idPersonne = rs.getLong("idPersonne");
        long idSalle = rs.getLong("idSalle");
        boolean autorise = (rs.getInt("autorise") == 1);
        Timestamp stamp = rs.getTimestamp("date");
        Date date = new Date(stamp.getTime());

        Personne personne = PhysiqueDataFactory.getPersonneDataService().getById(idPersonne);
        Salle salle = PhysiqueDataFactory.getSalleDataService().getById(idSalle);

        event = new Evenement();
        event.setId(id);
        event.setAutorise(autorise);
        event.setDate(date);
        event.setPersonne(personne);
        event.setSalle(salle);

        return event;
    }

    @Override
    public Evenement add(Evenement evenement) throws Exception {
        String strAutorise = "0";
        if (evenement.isAutorise()) {
            strAutorise = "1";
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String query = "INSERT INTO " + super.getEntityName() + " (id, date, idPersonne, idSalle, autorise) VALUES ('"
                + evenement.getId() + "','"
                + dateFormat.format(evenement.getDate()) + "','"
                + evenement.getPersonne().getId() + "','"
                + evenement.getSalle().getId() + "','"
                + strAutorise + "')";

        evenement.setId(super.executeAdd(query));
        return evenement;
    }

    @Override
    public void remove(Evenement evenement) throws Exception {
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + evenement.getId() + "'";
        super.executeQuery(query);
    }

    @Override
    public void update(Evenement evenement) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // A VERIFIER
    @Override
    public List<Evenement> getByJour(Date jour) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE date = '" + jour + "'";
        return super.getResults(query);
    }

    @Override
    public List<Evenement> getBySalle(Salle salle) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE idSalle = '" + salle.getId() + "'";
        return super.getResults(query);
    }
  
}
