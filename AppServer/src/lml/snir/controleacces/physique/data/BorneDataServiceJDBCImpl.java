/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.physique.data;

import java.sql.ResultSet;
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
        Borne b;

        long id = rs.getLong("id");
        long idSalle = rs.getLong("idSalle");

        Salle salle = PhysiqueDataFactory.getSalleDataService().getById(idSalle);

        b = new Borne();
        b.setId(id);
        b.setSalle(salle);
        return b;

    }

    @Override
    public Borne add(Borne t) throws Exception {
        String query = "INSERT INTO " + super.getEntityName() + " (id, idSalle) VALUES ('"
                + t.getId() + "','"
                + t.getSalle().getId() + "')";  //Filtre que l'id.

        t.setId(super.executeAdd(query));

        return t;

    }

    @Override
    public void remove(Borne t) throws Exception {
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + t.getId() + "'";
        super.executeQuery(query);

    }

    @Override
    public void update(Borne t) throws Exception {
        String query = "UPDATE " + super.getEntityName() + " SET id = '" + t.getId()
                + "', idSalle = '" + t.getSalle().getId()
                + "' WHERE id = '" + t.getId() + "'";

        t.setId(super.executeAdd(query));
    }

    @Override
    public Borne getBySalle(Salle salle) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE idSalle = '" + salle.getId() + "'";
        return super.getSingleResult(query);

    }

}
