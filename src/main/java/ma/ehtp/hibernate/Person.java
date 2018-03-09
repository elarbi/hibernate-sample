package ma.ehtp.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;

    public Person(String firstName) {
        this.firstName = firstName;
    }
    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Person (" + firstName +")";
    }
}
