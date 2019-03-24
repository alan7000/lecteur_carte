/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.physique.data;

import java.sql.ResultSet;
import java.util.List;
import lml.persistence.jdbc.AbstracCrudServiceJDBC;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author jupiter
 */
class BorneDataServiceJDBCImpl extends AbstracCrudServiceJDBC<Borne> implements BorneDataService {

    BorneDataServiceJDBCImpl() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS `" + super.getEntityName() + "` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `idSalle` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  UNIQUE KEY `idSalle` (`idSalle`)\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";
            super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("BorneDataServiceJDBCImpl() : " + ex);
        }
    }

    @Override
    protected Borne createEntity(ResultSet rs) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Borne b;

        long id = rs.getLong("id");
        long idSalle = rs.getLong("idSalle");
        //Salle salle = (Salle) rs.getObject("idSalle");

        Salle salle = PhysiqueDataFactory.getSalleDataService().getById(idSalle);

        b = new Borne();
        b.setId(id);
        b.setSalle(salle);
        return b;

    }

    @Override
    public Borne add(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "INSERT INTO " + super.getEntityName() + " (id, idSalle) VALUES ('"
                + t.getId() + "','"
                + t.getSalle().getId() + "')";  //Filtre que l'id.

        t.setId(super.executeAdd(query));

        return t;

    }

    @Override
    public void remove(Borne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + t.getId() + "'";
        super.executeQuery(query);

    }

    @Override
    public void update(Borne t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Borne getBySalle(Salle salle) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE idSalle = '" + salle.getId() + "'";
        return super.getSingleResult(query);

    }

}
