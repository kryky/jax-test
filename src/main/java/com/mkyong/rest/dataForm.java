package com.mkyong.rest;

import org.jboss.resteasy.annotations.Form;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by UI61LN on 7/13/2017.
 */

@Path("/HelloWorld")
public class dataForm {

    @POST
    @Path("/Info")
    public Response getPath(
            @FormParam("name") String name,
            @FormParam("age") int age,
            @FormParam("country") String country,
            @FormParam("hobby") String hobby) {

        String msg = "Your name is " + name + " and you are " + age + ". You are from " + country + " and your hobby is "
                + hobby + ".";
        return Response.status(200).entity(msg).build();
    }

}
