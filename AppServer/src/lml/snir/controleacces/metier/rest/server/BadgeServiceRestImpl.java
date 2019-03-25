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
import lml.snir.controleacces.metier.BadgeService;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Badge;

/**
 *
 * @author alan
 */
@Path("/BadgeService")
@Consumes("application/json")
@Produces("application/json")
public class BadgeServiceRestImpl {
    
    private final BadgeService badgeServiceRestImpl = MetierFactory.getBadgeService();

    @GET
    @PathParam("/getByContenu/{contenu}")
    public Badge getByContenu(@PathParam("contenu") String contenu) throws Exception {
        return badgeServiceRestImpl.getByContenu(contenu);
    }
    
    @POST
    @Path("/")
    public Badge add(Badge t) throws Exception {
        return badgeServiceRestImpl.add(t);
    }

    @DELETE
    @Path("/")
    public void remove(Badge t) throws Exception {
        badgeServiceRestImpl.remove(t);
    }

    @PUT
    public void update(Badge t) throws Exception {
        badgeServiceRestImpl.update(t);
    }

    @GET
    @Path("/{id}")
    public Badge getById(@PathParam("id") Long l) throws Exception {
        return badgeServiceRestImpl.getById(l);
    }

    @GET
    @Path("/Count")
    public long getCount() throws Exception {
        return badgeServiceRestImpl.getCount();
    }

    @GET
    @Path("/getAll")
    public List<Badge> getAll() throws Exception {
        return badgeServiceRestImpl.getAll();
    }

    @GET
    @Path("/{i}/{i1}")
    public List<Badge> getAll(@PathParam("i") int i, @PathParam("i1") int i1) throws Exception {
        return badgeServiceRestImpl.getAll(i, i1);
    }
    
    
    
}
