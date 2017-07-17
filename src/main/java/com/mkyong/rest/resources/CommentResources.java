package com.mkyong.rest.resources;

import com.mkyong.rest.model.Comment;
import com.mkyong.rest.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by UI61LN on 7/14/2017.
 */

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResources {

    CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
        return commentService.getAllComments(messageId);
    }

    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
        return commentService.getComment(messageId, commentId);
    }

    @POST
    public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
        return commentService.addComment(messageId, comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment) {
        comment.setId(commentId);
        return commentService.updateComment(messageId, comment);
    }

    @DELETE
    @Path("/{commentId}")
    public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
        return commentService.deleteComment(messageId, commentId);
    }
}
