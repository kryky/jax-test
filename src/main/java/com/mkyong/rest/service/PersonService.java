package com.mkyong.rest.service;

import com.mkyong.rest.database.DatabaseClass;
import com.mkyong.rest.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by UI61LN on 7/14/2017.
 */
public class PersonService {

    private Map<String, Person> persons = DatabaseClass.getPersons();

    public PersonService() {
        persons.put("kryky", new Person(1, "kryky", "Cristi", "Alexandrescu"));
        persons.put("MemeRocks", new Person(2, "MemeRocks", "Andrei", "Croitoru"));
        persons.put("Danyeris", new Person(3, "Danyeris", "Dani", "Petrache"));
    }

    public List<Person> getAllPersons() {

        return new ArrayList<Person>(persons.values());
    }

    public List<Person> getAllPersonsByLastName(String lastName) {
        List<Person> personsByLastName = new ArrayList<Person>();
        for(Person person : persons.values()) {
            if (person.getLastName().equals(lastName)) {
                personsByLastName.add(person);
            }
        }
        return personsByLastName;
    }

    public Person getPerson(String username) {

        return persons.get(username);
    }

    public Person addPerson(Person person) {
        person.setId(persons.size() + 1);
        persons.put(person.getUsername(), person);
        return person;
    }

    public Person updatePerson(Person person) {
        if (person.getUsername() != null && !person.getUsername().equals("")) {
            return null;
        }
        persons.put(person.getUsername(), person);
        return person;
    }

    public Person removePerson(String username) {

        return persons.remove(username);
    }
}
