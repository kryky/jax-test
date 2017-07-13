package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by UI61LN on 7/13/2017.
 */

@Path("/HelloWorld")
public class HelloWorld {

    @GET
    @Path("/")
    public Response getPath(@Context UriInfo info) {
        String msg = "Your name is " + info.getQueryParameters().getFirst("name") + " and you are "
                + info.getQueryParameters().getFirst("age") + " old." + "You are from "
                + info.getQueryParameters().getFirst("from") + " and your hobbies are: "
                + info.getQueryParameters().get("hobbies");

        return Response.status(200).entity(msg).build();
    }

}
