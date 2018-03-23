package ma.ehtp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public class DBUpdateWithHibernate {


    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dariPU");
        EntityManager em = entityManagerFactory.createEntityManager();

        //add a person
        Person elArbi = new Person("El Arbi");
        addPerson(elArbi, em);

        //create a house and rate it by existing person
        House house1 = new House("12 Bd Ghandi, Casablanca");
        Rating rating = new Rating(elArbi);
        house1.addRating(rating);

        addHouse(house1, em);

        //printing person table
        List<Person> people = listPersons(em);
        people.forEach(System.out::println);

        em.close();
        entityManagerFactory.close();

    }

    static void addPerson(Person person, EntityManager em) {
        em.getTransaction().begin();

        em.persist(person);

        em.getTransaction().commit();

    }

    static void addHouse(House house, EntityManager em) {
        em.getTransaction().begin();

        em.persist(house);

        em.getTransaction().commit();

    }


    static List<Person> listPersons(EntityManager entityManager) {
        List<Person> result =
                entityManager.createQuery("from Person", Person.class).getResultList();
        return result;
    }

}
