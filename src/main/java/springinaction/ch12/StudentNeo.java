package springinaction.ch12;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.security.auth.Subject;
import java.util.Set;

@NodeEntity
public class StudentNeo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    int id;
    private String firstName;
    private String lastName;
    private int age;
    @Relationship(type = "fuck")
    private Set<Subject> subjects;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}

@NodeEntity
class Teacher {
    @Relationship(type = "fuck", direction = Relationship.INCOMING)
    private String Subject;

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}