package lml.snir.controleacces.physique.data;

import java.sql.ResultSet;
import lml.persistence.jdbc.AbstracCrudServiceJDBC;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.entity.Personne;

final class AttributionDataServiceJDBCImpl extends AbstracCrudServiceJDBC<Attribution> implements AttributionDataService {

    AttributionDataServiceJDBCImpl() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS `" + super.getEntityName() + "` (\n"
                    + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                    + "  `idBadge` int(11) NOT NULL,\n"
                    + "  `idPersonne` int(11) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`),\n"
                    + "  UNIQUE KEY `idBadge` (`idBadge`),\n"
                    + "  UNIQUE KEY `idPersonne` (`idPersonne`)\n"
                    + ") ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;";
            super.executeQuery(query);

        } catch (Exception ex) {
            System.out.println("AttributionDataServiceJDBCImpl() : " + ex);
        }
    }

    @Override
    protected Attribution createEntity(ResultSet rs) throws Exception {
        Attribution attribution;

        long id = rs.getLong("id");
        long idBadge = rs.getLong("idBadge");
        long idPersonne = rs.getLong("idPersonne");

        attribution = new Attribution();
        attribution.setId(id);

        Badge badge = PhysiqueDataFactory.getBadgeDataService().getById(idBadge);
        Personne personne = PhysiqueDataFactory.getPersonneDataService().getById(idPersonne);
        attribution.setBadge(badge);
        attribution.setPersonne(personne);

        return attribution;
    }

    @Override
    public Attribution add(Attribution attribution) throws Exception {
        String query = "INSERT INTO " + super.getEntityName() + " (id, idBadge, idPersonne) VALUES ('"
                + attribution.getId() + "','"
                + attribution.getBadge().getId() + "','"
                + attribution.getPersonne().getId() + "')";

        attribution.setId(super.executeAdd(query));

        return attribution;
    }

    @Override
    public void remove(Attribution attribution) throws Exception {
        String query = "DELETE FROM " + super.getEntityName() + " WHERE id = '" + attribution.getId() + "'";
        super.executeQuery(query);
    }

    @Override
    public void update(Attribution attribution) throws Exception {
        String query = "UPDATE " + super.getEntityName() + " SET id = '"
                + attribution.getId() + "', idBadge = '"
                + attribution.getBadge().getId() + "',  idPersonne = '"
                + attribution.getPersonne().getId() + "' WHERE id = '" + attribution.getId() + "'";

        super.executeQuery(query);
    }

    @Override
    public Attribution getByBadge(Badge badge) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE idBadge = '" + badge.getId() + "'";
        return super.getSingleResult(query);
    }

    @Override
    public Attribution getByPersonne(Personne personne) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE idPersonne = '" + personne.getId() + "'";
        return super.getSingleResult(query);
    }

    public Boolean isBadgeAttribue(Personne personne) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE idPersonne = '" + personne.getId() + "'";
        return (super.getSingleResult(query) != null);
    }

    public Boolean isBadgeAttribue(Badge badge) throws Exception {
        String query = "SELECT * FROM " + super.getEntityName() + " WHERE idBadge = '" + badge.getId() + "'";
        return (super.getSingleResult(query) != null);
    }

}
