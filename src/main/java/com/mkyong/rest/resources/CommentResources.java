package com.mkyong.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by UI61LN on 7/14/2017.
 */

@Path("/")
public class CommentResources {

    @GET
    public String test() {
        return "new sub resources";
    }

    @GET
    @Path("/{commentId}")
    public String testCommentId(@PathParam("messageId") long messageId,
            @PathParam("commentId") long commentId) {
        return "CommentId " + commentId + " for messageId " + messageId;
    }
}
