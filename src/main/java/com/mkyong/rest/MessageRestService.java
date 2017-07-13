package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageRestService {

    @GET
    @Path("/{param}/{param2}")
    public Response printMessage(@PathParam("param") String msg, @PathParam("param2") String msg2) {

        String result = "My first example : " + msg;

        String result2 = "My second example : " + msg + " " + msg2;

        return Response.status(200).entity(result2).build();

    }

}