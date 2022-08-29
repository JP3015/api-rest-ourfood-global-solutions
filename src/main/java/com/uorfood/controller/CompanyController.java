package com.uorfood.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.uorfood.ddd.Company;
import com.uorfood.service.CompanyService;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;
import java.util.List;

@Path("/companies")
public class CompanyController {
    CompanyService companyService = new CompanyService();

    public CompanyController() throws SQLException {
    }


    @GET
    @Produces("application/json")
    public List<Company> getAllCompany() {
        return companyService.getALlCompany();
    }

    @GET
    @Path("{email}")
    @Produces("application/json")
    public List<Company> getCompanyById(@PathParam("email") String email) {
        return companyService.getCompanyByEmail(email);
    }

    @POST
    @Produces("application/json")
    public Response insertCompany(Company company, @Context UriInfo uri) {
        companyService.insertCompany(company);
        UriBuilder builder = uri.getAbsolutePathBuilder();
        builder.path(Integer.toString(company.getId()));
        return Response.accepted().build();
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public Response editCompany(Company company, @PathParam("id") Integer id) {
        companyService.editCompany(company, id);
        return Response.accepted().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCompany(@PathParam("id") Integer id) {
        companyService.deleteCompany(id);
        return Response.accepted().build();
    }

}
