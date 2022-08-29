package com.uorfood.controller;

import com.uorfood.ddd.Donation;
import com.uorfood.service.DonationService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/donations")
public class DonationController {
    private DonationService service = new DonationService();

    public DonationController() throws SQLException {
    }

    @GET
    @Produces("application/json")
    public List<Donation> getAllDonation() {
        return service.getAllDonation();
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    public List<Donation> getUserById(@PathParam("id") Integer id) {
        return service.getDonationById(id);

    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public Response updateDonation(Donation donation, @PathParam("id") Integer id) {
        service.updatedDonation(donation, id);
        return Response.accepted().build();
    }

}
