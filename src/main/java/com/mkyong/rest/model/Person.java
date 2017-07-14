package com.mkyong.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by UI61LN on 7/14/2017.
 */
@XmlRootElement
public class Person {

    private long id;
    private String username;
    private String lastName;
    private String firstName;

    public Person() {

    }

    public Person(long id, String username, String lastName, String firstName) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
