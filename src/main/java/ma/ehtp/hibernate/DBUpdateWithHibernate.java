package ma.ehtp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public class DBUpdateWithHibernate {


    public static void main(String[] args) {


        HouseRepository houseRepository = new HouseRepository();

        //add a person
        Person elArbi = new Person("El Arbi");
        houseRepository.addPerson(elArbi);

        //create a house and rate it by existing person
        House house1 = new House("12 Bd Ghandi, Casablanca");
        Rating rating = new Rating(elArbi);
        house1.addRating(rating);

        houseRepository.addHouse(house1);


    }

    static List<Person> listPersons(EntityManager entityManager) {
        List<Person> result =
                entityManager.createQuery("from Person", Person.class).getResultList();
        return result;
    }

}
