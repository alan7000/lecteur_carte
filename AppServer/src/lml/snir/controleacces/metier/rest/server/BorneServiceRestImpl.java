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
import lml.snir.controleacces.metier.BorneService;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Borne;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author alan
 */
@Path("/BorneService")
@Consumes("application/json")
@Produces("application/json")
public class BorneServiceRestImpl {

    private final BorneService borneServiceRestImpl = MetierFactory.getBorneService();

    @GET
    @Path("/getBySalle/{salle}")
    public Borne getBySalle(@PathParam("salle") long idsalle) throws Exception {
        Salle salle = MetierFactory.getSalleService().getById(idsalle);
        return borneServiceRestImpl.getBySalle(salle);
    }

    @POST
    @Path("/")
    public Borne add(Borne t) throws Exception {
        return borneServiceRestImpl.add(t);
    }

    @DELETE
    @Path("/")
    public void remove(Borne t) throws Exception {
        borneServiceRestImpl.remove(t);
    }

    @PUT
    @Path("/")
    public void update(Borne t) throws Exception {
        borneServiceRestImpl.update(t);
    }

    @GET
    @Path("/{id}")
    public Borne getById(@PathParam("id") Long l) throws Exception {
        return borneServiceRestImpl.getById(l);
    }

    @GET
    @Path("/Count")
    public long getCount() throws Exception {
        return borneServiceRestImpl.getCount();
    }

    @GET
    @Path("/")
    public List<Borne> getAll() throws Exception {
        return borneServiceRestImpl.getAll();
    }

    @GET
    @Path("/{i}/{i1}")
    public List<Borne> getAll(@PathParam("i") int i, @PathParam("i1") int i1) throws Exception {
        return borneServiceRestImpl.getAll(i, i1);
    }
}
