package com.mkyong.rest.resources;

import com.mkyong.rest.model.Person;
import com.mkyong.rest.service.PersonService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by UI61LN on 7/14/2017.
 */

@Path("/Persons")
public class PersonResources {

    private PersonService personService = new PersonService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons(@QueryParam("lastname") String lastname) {
        if (lastname != null && !lastname.equals("")) {
            return personService.getAllPersonsByLastName(lastname);
        }
        return personService.getAllPersons();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("username") String username) {
        return personService.getPerson(username);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person addPerson(Person person) {
        return personService.addPerson(person);
    }

    @PUT
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person updatePerson(@PathParam("username") String username, Person person) {
        person.setUsername(username);
        return personService.updatePerson(person);
    }

    @DELETE
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public void removePerson(@PathParam("username") String username, Person person) {
        personService.removePerson(username);
    }

}
