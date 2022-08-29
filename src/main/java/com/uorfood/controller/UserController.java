package com.uorfood.controller;

import com.uorfood.ddd.Users;
import com.uorfood.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;
import java.util.List;


@Path("/users")
public class UserController {
    UserService service = new UserService();


    public UserController() throws SQLException {
    }

    @GET
    @Produces("application/json")
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }

    @GET
    @Produces("application/json")
    @Path("/id={id}")
    public List<Users> getUserById(@PathParam("id") Integer id) {
        return service.getUserById(id);

    }

    @GET
    @Produces("application/json")
    @Path("/email={email}")

    public List<Users> getUserByEmail(@PathParam("email") String email) {
        return service.getUserByEmail(email);

    }


    @POST
    @Produces("application/json")
    public Response insertUsers(Users user, @Context UriInfo uri) {
        service.insertUsers(user);
        UriBuilder builder = uri.getAbsolutePathBuilder();
        builder.path(Integer.toString(user.getId()));
        return Response.accepted().build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public Response editUsers(Users users, @PathParam("id") Integer id) {
        service.editUsers(users, id);
        return Response.accepted().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Integer id) {
        service.deleteUser(id);
        return Response.accepted().build();
    }


}
