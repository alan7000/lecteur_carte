/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.physique.data;

import java.sql.ResultSet;
import java.util.List;
import lml.persistence.jdbc.AbstracCrudServiceJDBC;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author jupiter
 */
class SalleDataServiceJDBCImpl extends AbstracCrudServiceJDBC<Salle> implements SalleDataService {

    SalleDataServiceJDBCImpl() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS `" + super.getEntityName() + "` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `numero_de_la_salle` int(11) NOT NULL,\n"
                    + "  `protege` boolean NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";
            super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("SalleDataServiceJDBCImpl() : " + ex);
        }

    }

    @Override
    protected Salle createEntity(ResultSet rs) throws Exception {
        Salle s;

        long id = rs.getLong("id");
        long numero = rs.getLong("numero_de_la_salle");
        boolean protege = (rs.getInt("protege") == 1);

        s = new Salle(protege);
        s.setId(id);
        s.setNumero(numero);
        s.setProtege(protege);
        return s;
    }

    @Override
    public Salle add(Salle t) throws Exception {
        String strProtege = "0";
        if (t.isProtege()) {
            strProtege = "1";
        }

        String query = "INSERT INTO " + super.getEntityName() + " (id, numero_de_la_salle, protege) VALUES ('"
                + t.getId() + "','"
                + t.getNumero() + "','"
                + strProtege + "')";

        t.setId(super.executeAdd(query));

        return t;

    }

    @Override
    public void remove(Salle t) throws Exception {
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + t.getId() + "'";
        super.executeQuery(query);

    }

    @Override
    public void update(Salle t) throws Exception {
        String strProtege = "0";
        if (t.isProtege()) {
            strProtege = "1";
        }

        String query = "UPDATE " + super.getEntityName() + " SET id = '" + t.getId()
                + "', numero_de_la_salle = '" + t.getNumero()
                + "', protege = '" + strProtege
                + "' WHERE id = '" + t.getId() + "'";

        t.setId(super.executeAdd(query));
    }

    @Override
    public List<Salle> getByProtege(boolean protege) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE protege = '" + protege + "'";
        return super.getResults(query);

    }

    @Override
    public List<Salle> getNumero(long numero) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE numero_de_la_salle = '" + numero + "'";
        return super.getResults(query);
    }

}
