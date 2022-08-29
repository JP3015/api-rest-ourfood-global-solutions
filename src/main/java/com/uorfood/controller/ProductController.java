package com.uorfood.controller;

import com.uorfood.ddd.Products;
import com.uorfood.service.ProductService;

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


@Path("/products")
public class ProductController {
    ProductService service = new ProductService();

    public ProductController() throws SQLException {
    }

    @GET
    @Produces("application/json")
    public List<Products> getAllProduct() {
        return service.getAllProduct();
    }

    @POST
    @Produces("application/json")
    public Response insertProducts(Products products, @Context UriInfo uri) {
        service.insertProduct(products);
        UriBuilder builder = uri.getAbsolutePathBuilder();
        builder.path(Integer.toString(products.getId()));
        return Response.accepted().build();
    }
}
