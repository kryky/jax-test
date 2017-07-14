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
public class FileDownload {

    private static final String FILE_PATH = "D:\\\\Cristi\\file.txt";

    @GET
    @Path("/Text")
    @Produces("text/plain")
    //@Produces("application/pdf")              //For PDF
    //@Produces("application/vnd.ms-excel")     //For Excel
    public Response downloadTextFile() {

        File file = new File(FILE_PATH);

        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename=file.txt");
        return response.build();

    }
}
