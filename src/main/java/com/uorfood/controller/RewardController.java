package com.uorfood.controller;


import com.uorfood.ddd.Reward;
import com.uorfood.service.RewardService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;
import java.util.List;

@Path("/rewards")
public class RewardController {
    RewardService service = new RewardService();

    public RewardController() throws SQLException {
    }

    @GET
    @Produces("application/json")
    public List<Reward> getAllReward() {
        return service.getAllReward();
    }

    @POST
    @Produces("application/json")
    public Response insertReward(Reward reward, @Context UriInfo uri) {
        service.insertReward(reward);
        UriBuilder builder = uri.getAbsolutePathBuilder();
        builder.path(Integer.toString(reward.getId()));
        return Response.accepted().build();
    }
}
