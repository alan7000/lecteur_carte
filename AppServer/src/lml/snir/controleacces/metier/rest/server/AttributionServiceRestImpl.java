/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier.rest.server;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import lml.snir.controleacces.metier.AttributionService;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Attribution;
import lml.snir.controleacces.metier.entity.Badge;
import lml.snir.controleacces.metier.entity.Personne;

/**
 *
 * @author alan
 */
@Path("/AttributionService")
@Consumes("application/json")
@Produces("application/json")
public class AttributionServiceRestImpl {

    private final AttributionService attributionServiceRestImpl = MetierFactory.getAttributionService();

    @POST
    @Path("/")
    public Attribution add(Attribution t) throws Exception {
        return attributionServiceRestImpl.add(t);
    }

    @DELETE
    @Path("/")
    public void remove(Attribution t) throws Exception {
        attributionServiceRestImpl.remove(t);
    }

    @PUT
    @Path("/")
    public void update(Attribution t) throws Exception {
        attributionServiceRestImpl.update(t);
    }

    @GET
    @Path("/{id}")
    public Attribution getById(@PathParam("id") Long l) throws Exception {
        return attributionServiceRestImpl.getById(l);
    }

    @GET
    @Path("/Count")
    public long getCount() throws Exception {
        return attributionServiceRestImpl.getCount();
    }

    @GET
    @Path("/")
    public List<Attribution> getAll() throws Exception {
        return attributionServiceRestImpl.getAll();
    }

    @GET
    @Path("/{i}/{i1}")
    public List<Attribution> getAll(@PathParam("i") int i, @PathParam("i1") int i1) throws Exception {
        return attributionServiceRestImpl.getAll(i, i1);
    }

    @GET
    @Path("/getByBadge/{badge}")
    public Attribution getByBadge(@PathParam("badge") long idbadge) throws Exception {
        Badge badge = MetierFactory.getBadgeService().getById(idbadge);
        return attributionServiceRestImpl.getByBadge(badge);
    }

    @GET
    @Path("/getByPersonne/{personne}")
    public Attribution getByPersonne(@PathParam("personne") long idpersonne) throws Exception {
        Personne personne = MetierFactory.getPersonneService().getById(idpersonne);
        return attributionServiceRestImpl.getByPersonne(personne);
    }

    @GET
    @Path("/badgeAttribuePersonne/{personne}")
    public Boolean isBadgeAttribue(@PathParam("personne") long idpersonne) throws Exception {
        Personne personne = MetierFactory.getPersonneService().getById(idpersonne);
        return attributionServiceRestImpl.isBadgeAttribue(personne);
    }

    @PUT
    @Path("/badgeAttribueBadge/{badge}")
    public Boolean isBadgeAttribueBadge(@PathParam("badge") long idbadge) throws Exception {
        Badge badge = MetierFactory.getBadgeService().getById(idbadge);
        return attributionServiceRestImpl.isBadgeAttribue(badge);
    }
}
