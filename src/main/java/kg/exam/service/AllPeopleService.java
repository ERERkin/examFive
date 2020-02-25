package kg.exam.service;

import kg.exam.dao.PersonDao;
import kg.exam.model.Person;
import lombok.SneakyThrows;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/getAllPeople")
public class AllPeopleService {
    @SneakyThrows
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Person> getAllPeople(){
        PersonDao personDao = new PersonDao();
        return personDao.getAllPersons();
    }
    @GET
    @Path("/{name}&{year}&{gender}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Person> getSomePeople(@PathParam("name") String name, @PathParam("year") Integer year, @PathParam("gender") String gender) {
        Person person = Person.builder()
                .name(name).year(year).gender(gender).build();
        PersonDao personDao = new PersonDao();
        return personDao.getAllPersons(person);
    }
    @DELETE
    @Path("/{personId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("personId") Integer personId){
        PersonDao personDao = new PersonDao();
        personDao.deletePerson(personId);
    }
    //Не успевал по нормальному
}
