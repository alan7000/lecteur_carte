/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier.rest.server;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import lml.snir.controleacces.metier.EvenementService;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Evenement;
import lml.snir.controleacces.metier.entity.Salle;

/**
 *
 * @author alan
 */
@Path("/EvenementService")
@Consumes("application/json")
@Produces("application/json")
public class EvenementServiceRestImpl {

    private final EvenementService evenementServiceRestImpl = MetierFactory.getEvenementService();

    @GET
    @Path("/getByJour/{jour}")
    public List<Evenement> getByJour(@PathParam("jour") Date idjour) throws Exception {
        Date jour = (Date) MetierFactory.getEvenementService().getByJour(idjour);
        return evenementServiceRestImpl.getByJour(jour);
    }

    @GET
    @Path("/getBySalle/{salle}")
    public List<Evenement> getBySalle(@PathParam("salle") long idsalle) throws Exception {
        Salle salle = MetierFactory.getSalleService().getById(idsalle);
        return evenementServiceRestImpl.getBySalle(salle);
    }

    @POST
    @Path("/")
    public Evenement add(Evenement t) throws Exception {
        return evenementServiceRestImpl.add(t);
    }

    @DELETE
    @Path("/")
    public void remove(Evenement t) throws Exception {
        evenementServiceRestImpl.remove(t);
    }

    @PUT
    @Path("/")
    public void update(Evenement t) throws Exception {
        evenementServiceRestImpl.update(t);
    }

    @GET
    @Path("/{id}")
    public Evenement getById(@PathParam("id") Long l) throws Exception {
        return evenementServiceRestImpl.getById(l);
    }

    @GET
    @Path("/Count")
    public long getCount() throws Exception {
        return evenementServiceRestImpl.getCount();
    }

    @GET
    @Path("/")
    public List<Evenement> getAll() throws Exception {
        return evenementServiceRestImpl.getAll();
    }

    @GET
    @Path("/{i}/{i1}")
    public List<Evenement> getAll(@PathParam("i") int i, @PathParam("i1") int i1) throws Exception {
        return evenementServiceRestImpl.getAll(i, i1);
    }

}
