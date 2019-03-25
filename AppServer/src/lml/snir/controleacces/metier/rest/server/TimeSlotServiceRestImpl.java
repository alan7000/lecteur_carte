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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import lml.snir.controleacces.metier.MetierFactory;
import lml.snir.controleacces.metier.TimeSlotService;
import lml.snir.controleacces.metier.entity.TimeSlot;
import lml.snir.controleacces.physique.data.TimeSlotDataService;

/**
 *
 * @author alan
 */
@Path("/TimeSlotService")
@Consumes("application/json")
@Produces("application/json")
public class TimeSlotServiceRestImpl {
    
    private final TimeSlotService timeSlotDataServiceRestImpl = MetierFactory.getTimeSlotService();

    @GET
    @Path("/")
    public TimeSlot add(TimeSlot t) throws Exception {
        return timeSlotDataServiceRestImpl.add(t);
    }

    @DELETE
    @Path("/")
    public void remove(TimeSlot t) throws Exception {
        timeSlotDataServiceRestImpl.remove(t);
    }

    @PUT
    @Path("/")
    public void update(TimeSlot t) throws Exception {
        timeSlotDataServiceRestImpl.update(t);
    }

    @GET
    @Path("/{id}")
    public TimeSlot getById(@PathParam("id") Long l) throws Exception {
        return timeSlotDataServiceRestImpl.getById(l);
    }

    @GET
    @Path("/Count")
    public long getCount() throws Exception {
        return timeSlotDataServiceRestImpl.getCount();
    }

    @GET
    @Path("/getAll")
    public List<TimeSlot> getAll() throws Exception {
        return timeSlotDataServiceRestImpl.getAll();
    }

    @GET
    @Path("/{i}/{i1}")
    public List<TimeSlot> getAll(@PathParam("i") int i, @PathParam("i1") int i1) throws Exception {
        return timeSlotDataServiceRestImpl.getAll(i, i1);
    }
    
    
}
