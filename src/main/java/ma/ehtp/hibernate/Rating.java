package ma.ehtp.hibernate;

import javax.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;

    private double rate;

    public Rating(Person ratedBy){
        this.person = ratedBy;
    }


}
