package com.mkyong.rest.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by UI61LN on 7/14/2017.
 */

@Path("/Parameters")
@Produces(MediaType.TEXT_PLAIN)
public class InjectParameters {

    @GET
    @Path("/Annotations")
    public String getAnnotationsParameters(@MatrixParam("param") String matrixParam,
                                @HeaderParam("header") String headerParam,
                                @CookieParam("name") String cookieParam) {
        return "Matrix param: " + matrixParam + " Header param: " + headerParam + " Cookie param: " + cookieParam;
    }

    @GET
    @Path("/Context")
    public String getContextParameters(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return "Path: " + path + " Cookies: " + cookies;
    }
}
