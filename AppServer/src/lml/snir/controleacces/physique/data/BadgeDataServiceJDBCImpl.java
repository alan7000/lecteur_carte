/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.physique.data;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import lml.persistence.jdbc.AbstracCrudServiceJDBC;
import lml.snir.controleacces.metier.entity.Badge;

/**
 *
 * @author jupiter
 */
class BadgeDataServiceJDBCImpl extends AbstracCrudServiceJDBC<Badge> implements BadgeDataService {

    BadgeDataServiceJDBCImpl() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS `" + super.getEntityName() + "` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `contenu` varchar(255) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  UNIQUE KEY `contenu` (`contenu`)\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";
            super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("BadgeDataServiceJDBCImpl() : " + ex);
        }
    }

    @Override
    protected Badge createEntity(ResultSet rs) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Badge b;

        long id = rs.getLong("id");
        String contenu = rs.getString("contenu");

        b = new Badge();
        b.setId(id);
        b.setContenu(contenu);

        return b;
    }

    @Override
    public Badge add(Badge t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "INSERT INTO " + super.getEntityName() + " (id, contenu) VALUES ('"
                + t.getId() + "','"
                + t.getContenu() + "')";

        t.setId(super.executeAdd(query));

        return t;
    }

    @Override
    public void remove(Badge t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + t.getId() + "'";
        super.executeQuery(query);

    }

    @Override
    public void update(Badge t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Badge getByContenu(String contenu) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE contenu = '" + contenu.toString() + "'";
        return super.getSingleResult(query);

    }

}
