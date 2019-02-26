/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.physique.data;

import java.io.ByteArrayInputStream;
import java.sql.ResultSet;
import java.util.List;
import lml.persistence.jdbc.AbstracCrudServiceJDBC;
import lml.snir.controleacces.metier.entity.Administrateur;
import lml.snir.controleacces.metier.entity.Personne;

/**
 *
 * @author jupiter
 */
class PersonneDataServiceJDBCImpl extends AbstracCrudServiceJDBC<Personne> implements PersonneDataService {

    PersonneDataServiceJDBCImpl() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS `" + super.getEntityName() + "` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT\n"
                    + "  `nom` varchar(255) NOT NULL\n"
                    + "  `prenom` varchar(255) NOT NULL\n"
                    + "  `login` varchar(255)\n"
                    + "  `password` varchar(255)\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  UNIQUE KEY `nom` (`nom`),\n"
                    + "  UNIQUE KEY `prenom` (`prenom`),\n"
                    + "  UNIQUE KEY `login` (`login`),\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";
            super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("PersonneDataServiceJDBCImpl() : " + ex);
        }
    }

    @Override
    protected Personne createEntity(ResultSet rs) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Personne p;

        long id = rs.getLong("id");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");

        p = new Personne();
        p.setId(id);
        p.setNom(nom);
        p.setPrenom(prenom);

        if (p instanceof Administrateur) {
            Administrateur adm = new Administrateur();
            String login = rs.getString("login");
            adm.setLogin(login);
            String password = rs.getString("password");
            adm.setMdp(password);
        }
        return p;

    }

    @Override
    public Personne add(Personne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "INSERT INTO " + super.getEntityName() + " (id, nom, prenom) VALUES ('"
                + t.getId() + "','"
                + t.getNom() + "','"
                + t.getPrenom() + "')";
        if (t instanceof Administrateur) {
            Administrateur adm = (Administrateur) t;
            query = "INSERT INTO " + super.getEntityName() + " (id, nom, prenom, login, password) VALUES ('"
                    + t.getId() + "','"
                    + t.getNom() + "','"
                    + t.getPrenom() + "','"
                    + adm.getLogin() + "','"
                    + adm.getMdp() + "')";
        }

        t.setId(super.executeAdd(query));

        return t;

    }

    @Override
    public void remove(Personne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + t.getId() + "'";
        super.executeQuery(query);

    }

    @Override
    public void update(Personne t) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
String query = "UPDATE " + super.getEntityName() + " SET nom = '" + t.getNom() + 
                "', prenom = '" + t.getPrenom() + 
                "' WHERE id = '" + t.getId() + "'";
        if (t instanceof Administrateur) {
            Administrateur adm = (Administrateur) t;
            query = "UPDATE " + super.getEntityName() + " SET nom = '" + t.getNom() + 
                    "', prenom = '" + t.getPrenom() + 
                    "',  login = '" + adm.getLogin() + 
                    "',  password = '" + adm.getMdp() + 
                    "' WHERE id = '" + t.getId() + "'";
        }
        t.setId(super.executeAdd(query, new ByteArrayInputStream[0]));
    }

    @Override
    public Administrateur getByLogin(String login) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE login = '" + login.toString() + "'";
        return (Administrateur) super.getSingleResult(query);

    }

    @Override
    public List<Personne> getByNom(String nom) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE nom = '" + nom.toString() + "'";
        return (List<Personne>) super.getSingleResult(query);

    }

}
