/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.physique.data;

import java.sql.ResultSet;
import java.util.List;
import lml.persistence.jdbc.AbstracCrudServiceJDBC;
import lml.snir.controleacces.metier.entity.Autorisation;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.entity.TimeSlot;

/**
 *
 * @author jupiter
 */
class AutorisationDataServiceJDBCImpl extends AbstracCrudServiceJDBC<Autorisation> implements AutorisationDataService {

    AutorisationDataServiceJDBCImpl() {
        try{
        String query = "CREATE TABLE IF NOT EXISTS `" + super.getEntityName() + "` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `idSalle` int(11) NOT NULL,\n"
                + "  `idPersonne` int(11) NOT NULL,\n"
                + "  `idPlageHoraire` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";
        super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("AutorisationDataServiceJDBCImpl() : " + ex);
        }
    }

    @Override
    protected Autorisation createEntity(ResultSet rs) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Autorisation a;

        long id = rs.getLong("id");
        long idSalle = rs.getLong("idSalle");
        long idPersonne = rs.getLong("idPersonne");
        long idPlageHoraire = rs.getLong("idPlageHoraire");

        Salle salle = PhysiqueDataFactory.getSalleDataService().getById(idSalle);
        Personne personne = PhysiqueDataFactory.getPersonneDataService().getById(idPersonne);
        TimeSlot timeSlot = PhysiqueDataFactory.getTimeSlotService().getById(idPlageHoraire);

        a = new Autorisation();
        a.setId(id);
        a.setPersonne(personne);
        a.setPlageHoraire(timeSlot);
        a.setSalle(salle);

        return a;

    }

    @Override
    public Autorisation add(Autorisation t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "INSERT INTO " + super.getEntityName() + " (id, idSalle, idPersonne, idPlageHoraire) VALUES ('"
                + t.getId() + "','"
                + t.getSalle().getId() + "','"
                + t.getPersonne().getId() + "','"
                + t.getPlageHoraire().getId() + "')";

        t.setId(super.executeAdd(query));

        return t;

    }

    @Override
    public void remove(Autorisation t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + t.getId() + "'";
        super.executeQuery(query);
    }

    @Override
    public void update(Autorisation t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String query = "UPDATE " + super.getEntityName() + " SET id = '"
            + t.getId() + "', idSalle = '"
            + t.getSalle().getId() + "', idPersonne = '"
            + t.getPersonne().getId() + "', idPlageHoraire = '"
            + t.getPlageHoraire().getId() + "' WHERE id = '" + t.getId() + "'";
    
    super.executeQuery(query);
    }

    @Override
    public List<Autorisation> getBySalle(Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String query = "SELECT * FROM " + super.getEntityName() + " WHERE idSalle = '" + salle.getId() + "'";
        return super.getResults(query);
    }

    @Override
    public List<Autorisation> getByPersonne(Personne personne) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String query = "SELECT * FROM " + super.getEntityName() + " WHERE idPersonne = '" + personne.getId() + "'";
        return super.getResults(query);
    }

    @Override
    public List<Autorisation> getByPlageHoraire(TimeSlot plageHoraire) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String query = "SELECT * FROM " + super.getEntityName() + " WHERE idPlageHoraire = '" + plageHoraire.getId() + "'";
        return super.getResults(query);
    }

    @Override
    public List<Autorisation> getByPeronneEtSalle(Personne personne, Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String query = "SELECT * FROM " + super.getEntityName() + " WHERE idPersonne = '" + personne.getId() + "' AND idSalle = '" + salle.getId() + "'";
        return super.getResults(query);
    }

}
