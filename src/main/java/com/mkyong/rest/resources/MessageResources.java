package com.mkyong.rest.resources;

import com.mkyong.rest.model.Message;
import com.mkyong.rest.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by UI61LN on 7/14/2017.
 */

@Path("/Messages")
public class MessageResources {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
       return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") long messageId) {
        return messageService.getMessage(messageId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
        message.setId(messageId);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removeMessage(@PathParam("messageId") long messageId, Message message) {
        messageService.removeMessage(messageId);
    }

}
