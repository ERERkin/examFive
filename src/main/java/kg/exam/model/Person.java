package kg.exam.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@XmlRootElement(name = "person")
public class Person {
    int id;
    String name;
    int year;
    String gender;
    Timestamp createdDate;
}
