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
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.SalleService;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author alan
 */
@Path("/SalleService")
@Consumes("application/json")
@Produces("application/json")
public class SalleServiceRestImpl {

    private final SalleService salleServiceRestImpl = MetierFactory.getSalleService();

    @GET
    @Path("/getByProtege/{protege}")
    public List<Salle> getByProtege(@PathParam("protege") boolean protege) throws Exception {
        return salleServiceRestImpl.getByProtege(protege);
    }

    @POST
    @Path("/")
    public Salle add(Salle t) throws Exception {
        return salleServiceRestImpl.add(t);
    }

    @DELETE
    @Path("/")
    public void remove(Salle t) throws Exception {
        salleServiceRestImpl.remove(t);
    }

    @PUT
    @Path("/")
    public void update(Salle t) throws Exception {
        salleServiceRestImpl.update(t);
    }

    @GET
    @Path("/{id}")
    public Salle getById(@PathParam("id") Long l) throws Exception {
        return salleServiceRestImpl.getById(l);
    }

    @GET
    @Path("/Count")
    public long getCount() throws Exception {
        return salleServiceRestImpl.getCount();
    }

    @GET
    @Path("/")
    public List<Salle> getAll() throws Exception {
        return salleServiceRestImpl.getAll();
    }

    @GET
    @Path("/{i}/{i1}")
    public List<Salle> getAll(@PathParam("i") int i, @PathParam("i1") int i1) throws Exception {
        return salleServiceRestImpl.getAll(i, i1);
    }

}
