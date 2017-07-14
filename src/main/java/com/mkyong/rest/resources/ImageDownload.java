package com.mkyong.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * Created by UI61LN on 7/13/2017.
 */
@Path("/Download")
public class ImageDownload {

    private static final String IMAGE_PATH = "D:\\\\Cristi\\image.png";

    @GET
    @Path("/Image")
    @Produces("image/png")
    public Response downloadImage() {

        File file = new File(IMAGE_PATH);

        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=image.png");
        return response.build();
    }
}
