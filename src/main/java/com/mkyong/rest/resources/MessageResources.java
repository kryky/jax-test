package com.mkyong.rest.resources;

import com.mkyong.rest.model.Message;
import com.mkyong.rest.service.MessageService;
import com.sun.jndi.toolkit.url.Uri;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by UI61LN on 7/14/2017.
 */

@Path("/Messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResources {

    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages() {
       return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
        Message message =  messageService.getMessage(messageId);
        message.addLink(getUriForSelf(uriInfo, message), "self");
        message.addLink(getUriForPerson(uriInfo, message), "author");
        message.addLink(getUriForComments(uriInfo, message), "comments");
        return message;
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
        Message newMessage = messageService.addMessage(message);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newMessage.getId())).build();
        return Response.created(uri)
                .entity(newMessage)
                .build();
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
        message.setId(messageId);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void removeMessage(@PathParam("messageId") long messageId, Message message) {
        messageService.removeMessage(messageId);
    }

    @Path("/{messageId}/Comments")
    public CommentResources getCommentResources() {
        return new CommentResources();
    }

    private String getUriForPerson(@Context UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                .path(PersonResources.class)
                .path(message.getUser())
                .build()
                .toString();
    }

    private String getUriForSelf(@Context UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                .path(MessageResources.class)
                .path(Long.toString(message.getId()))
                .build()
                .toString();
    }

    private String getUriForComments(@Context UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                .path(MessageResources.class)
//                .path(MessageResources.class, "getCommentResources")
                .path(CommentResources.class)
//                .resolveTemplate("messageId", message.getId())
                .build()
                .toString();
    }
}
