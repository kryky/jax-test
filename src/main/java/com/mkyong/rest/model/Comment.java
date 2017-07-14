package com.mkyong.rest.model;

/**
 * Created by UI61LN on 7/14/2017.
 */
public class Comment {

    private long id;
    private String message;
    private String author;

    public Comment() {

    }

    public Comment(long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
