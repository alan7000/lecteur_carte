/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.physique.data;

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
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `nom` varchar(255) NOT NULL,\n"
                    + "  `prenom` varchar(255) NOT NULL,\n"
                    + "  `login` varchar(255),\n"
                    + "  `password` varchar(255),\n"
                    + "  `classe` varchar(255) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  UNIQUE KEY `nom` (`nom`),\n"
                    + "  UNIQUE KEY `prenom` (`prenom`),\n"
                    + "  UNIQUE KEY `login` (`login`)\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;";
            super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("PersonneDataServiceJDBCImpl() : " + ex);
        }
    }

    @Override
    protected Personne createEntity(ResultSet rs) throws Exception { 

        long id = rs.getLong("id");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        String classe = rs.getString("classe");
        Personne p;
        if(classe.equals(Personne.class.getSimpleName())){
            p = new Personne(nom, prenom);
        } else {
            Administrateur adm = new Administrateur(nom, prenom);
            String login = rs.getString("login");
            adm.setLogin(login);
            String password = rs.getString("password");
            adm.setMdp(password);
            p = adm;
        }
        
        p.setId(id);
        
        return p;

    }

    @Override
    public Personne add(Personne t) throws Exception {
        String query = "INSERT INTO " + super.getEntityName() + " (id, nom, prenom, classe) VALUES ('"
                + t.getId() + "','"
                + t.getNom() + "','"
                + t.getPrenom() + "','"
                + t.getClass().getSimpleName() + "')";
        if (t instanceof Administrateur) {
            Administrateur adm = (Administrateur) t;
            query = "INSERT INTO " + super.getEntityName() + " (id, nom, prenom, login, password, classe) VALUES ('"
                    + t.getId() + "','"
                    + t.getNom() + "','"
                    + t.getPrenom() + "','"
                    + adm.getLogin() + "','"
                    + adm.getMdp() + "','"
                    + adm.getClass().getSimpleName() + "')";
        }

        t.setId(super.executeAdd(query));

        return t;

    }

    @Override
    public void remove(Personne t) throws Exception {
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + t.getId() + "'";
        super.executeQuery(query);

    }

    @Override
    public void update(Personne t) throws Exception {
        String query = "UPDATE " + super.getEntityName() + " SET nom = '" + t.getNom()
                + "', prenom = '" + t.getPrenom()
                + "' WHERE id = '" + t.getId() + "'";
        if (t instanceof Administrateur) {
            Administrateur adm = (Administrateur) t;
            query = "UPDATE " + super.getEntityName() + " SET nom = '" + t.getNom()
                    + "', prenom = '" + t.getPrenom()
                    + "',  login = '" + adm.getLogin()
                    + "',  password = '" + adm.getMdp()
                    + "' WHERE id = '" + t.getId() + "'";
        }
        t.setId(super.executeAdd(query));
    }

    @Override
    public Administrateur getByLogin(String login) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE login = '" + login + "'";
        Object o = super.getSingleResult(query);
        return (Administrateur) o;

    }

    @Override
    public List<Personne> getByNom(String nom) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE nom = '" + nom.toString() + "'";
        return super.getResults(query);

    }

}
