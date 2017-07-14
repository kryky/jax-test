package com.mkyong.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by UI61LN on 7/14/2017.
 */
@XmlRootElement
public class Message {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String message;
    private String user;

    public Message() {

    }

    public Message(long id, String message, String user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
