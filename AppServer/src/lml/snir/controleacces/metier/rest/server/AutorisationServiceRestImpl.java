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
import lml.snir.controleacces.metier.AutorisationService;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.entity.Autorisation;
import lml.snir.controleacces.metier.entity.Personne;
import lml.snir.controleacces.metier.entity.Salle;
import lml.snir.controleacces.metier.entity.TimeSlot;

/**
 *
 * @author alan
 */
@Path("/AutorisationService")
@Consumes("application/json")
@Produces("application/json")
public class AutorisationServiceRestImpl {

    private final AutorisationService autorisationServiceRestImpl = MetierFactory.getAutorisationService();

    @GET
    @Path("/getBySalle/{salle}")
    public List<Autorisation> getBySalle(@PathParam("salle") long idsalle) throws Exception {
        Salle salle = MetierFactory.getSalleService().getById(idsalle);
        return autorisationServiceRestImpl.getBySalle(salle);
    }

    @GET
    @Path("/getByPersonne/{personne}")
    public List<Autorisation> getByPersonne(@PathParam("personne") long idpersonne) throws Exception {
        Personne personne = MetierFactory.getPersonneService().getById(idpersonne);
        return autorisationServiceRestImpl.getByPersonne(personne);
    }

    @GET
    @Path("/getByPlageHoraire/{plageHoraire}")
    public List<Autorisation> getByPlageHoraire(@PathParam("plageHoraire") long idplageHoraire) throws Exception {
        TimeSlot plageHoraire = MetierFactory.getTimeSlotService().getById(idplageHoraire);
        return autorisationServiceRestImpl.getByPlageHoraire(plageHoraire);
    }

    @GET
    @Path("/getByPersonneEtSalle/{personne}/{salle}")
    public List<Autorisation> getByPeronneEtSalle(@PathParam("personne") long idpersonne, @PathParam("salle") long idsalle) throws Exception {
        Personne personne = MetierFactory.getPersonneService().getById(idpersonne);
        Salle salle = MetierFactory.getSalleService().getById(idsalle);
        return autorisationServiceRestImpl.getByPeronneEtSalle(personne, salle);
    }

    @POST
    @Path("/")
    public Autorisation add(Autorisation t) throws Exception {
        return autorisationServiceRestImpl.add(t);
    }

    @DELETE
    @Path("/")
    public void remove(Autorisation t) throws Exception {
        autorisationServiceRestImpl.remove(t);
    }

    @PUT
    @Path("/")
    public void update(Autorisation t) throws Exception {
        autorisationServiceRestImpl.update(t);
    }

    @GET
    @Path("/{id}")
    public Autorisation getById(@PathParam("id") Long l) throws Exception {
        return autorisationServiceRestImpl.getById(l);
    }

    @GET
    @Path("/Count")
    public long getCount() throws Exception {
        return autorisationServiceRestImpl.getCount();
    }

    @GET
    @Path("/getAll")
    public List<Autorisation> getAll() throws Exception {
        return autorisationServiceRestImpl.getAll();
    }

    @GET
    @Path("/{i}/{i1}")
    public List<Autorisation> getAll(@PathParam("i") int i, @PathParam("i1") int i1) throws Exception {
        return autorisationServiceRestImpl.getAll(i, i1);
    }

}
