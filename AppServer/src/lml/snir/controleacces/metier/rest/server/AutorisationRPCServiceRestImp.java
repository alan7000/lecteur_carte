/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lml.snir.controleacces.metier.rest.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import lml.snir.controleacces.metier.AutorisationRPCService;
import lml.snir.controleacces.metier.MetierFactory;

/**
 *
 * @author alan
 */
@Path("/AutorisationRPCService")
@Consumes("application/json")
@Produces("application/json")
public class AutorisationRPCServiceRestImp {
    
    private final AutorisationRPCService autorisationRPCRestImp = MetierFactory.getAutorisationRPCService();

    /*
    Voir avec le prof
    */
    @GET
    @Path("/isAutorise/{badgeContent}/{salle}/{date}")
    public Boolean isAutorise(@PathParam("badgeContent") String badgeContent, @PathParam("salle") Integer salle, @PathParam("date") String date) throws Exception {
        return autorisationRPCRestImp.isAutorise(badgeContent, salle, date);
    }
    
    
    
}
