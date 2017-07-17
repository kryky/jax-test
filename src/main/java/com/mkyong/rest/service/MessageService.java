package com.mkyong.rest.service;

import com.mkyong.rest.database.DatabaseClass;
import com.mkyong.rest.exception.DataNotFoundException;
import com.mkyong.rest.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by UI61LN on 7/14/2017.
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "Blablabla", "Cristi"));
        messages.put(2L, new Message(2, "Hello Wold!", "Andrei"));
        messages.put(3L, new Message(3, "Hello Romania!", "Alex"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(long id) {
        Message message = messages.get(id);
        if (message == null) {
            throw new DataNotFoundException("Message with id " + id + " not found!");
        }
        return message;
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
