package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Created by UI61LN on 7/13/2017.
 */

@Path("/HelloWorld")
public class HelloWorld {

    @GET
    @Path("/{param}")
    public Response getPath(@PathParam("param") String message) {
        String msg = "Your first word: " + message;

        return Response.status(200).entity(msg).build();
    }

}
