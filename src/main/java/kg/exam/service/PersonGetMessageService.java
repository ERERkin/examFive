package kg.exam.service;

import kg.exam.dao.PersonDao;
import kg.exam.model.Person;
import lombok.SneakyThrows;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Map;

import static java.time.Year.now;

@Path("/getMessage")
public class PersonGetMessageService {
    @SneakyThrows
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String getMessage(Person person){
        PersonDao personDao = new PersonDao();
        Person person1 = personDao.createPerson(person);
        if (person.getYear() > 2000 || person1 == null) throw new Exception("Error");
        return "Уважаемый " + person.getName() + ", ваш год рождения" + person.getYear() + ", вам" + (2020 - person.getYear()) + " лет";
    }
}
