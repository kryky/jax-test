package com.mkyong.rest.database;

import com.mkyong.rest.model.Message;
import com.mkyong.rest.model.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by UI61LN on 7/14/2017.
 */
public class DatabaseClass {

    private static Map<Long, Message> messages = new HashMap();
    private static Map<String, Person> persons = new HashMap();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Person> getPersons() {
        return persons;
    }
}
