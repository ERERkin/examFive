package kg.exam.dao;

import kg.exam.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    public Person createPerson(Person person){
        String SQL = "insert into people1(name, year, gender, created_date) VALUES (?,?,?,now());";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, person.getName());
            statement.setInt(2, person.getYear());
            statement.setString(3, person.getGender());
            statement.executeUpdate();
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Person> getAllPersons(){
        List<Person> people = new ArrayList<>();
        String SQL = "select * from people1;";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            try(ResultSet rs = statement.executeQuery()){
                while (rs.next()){
                    people.add(Person.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .year(rs.getInt("year"))
                            .gender(rs.getString("gender"))
                            .createdDate(rs.getTimestamp("created_date"))
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public List<Person> getAllPersons(Person person){
        List<Person> people = new ArrayList<>();
        String SQL = "select * from people1 where name = ? or year = ? or gender = ?;";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            System.out.println(person.getName());
            System.out.println(person.getYear());
            System.out.println(person.getGender());
            statement.setString(1, person.getName());
            statement.setInt(2, person.getYear());
            statement.setString(3, person.getGender());
            try(ResultSet rs = statement.executeQuery()){
                while (rs.next()){
                    people.add(Person.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .year(rs.getInt("year"))
                            .gender(rs.getString("gender"))
                            .createdDate(rs.getTimestamp("created_date"))
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public void deletePerson(int personId){
        String SQL = "delete from people1 where id = ?;";
        try (Connection connection = DB.connect();
             PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setInt(1, personId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
