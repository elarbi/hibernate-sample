package ma.ehtp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public class DBUpdateWithHibernate {


    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dariPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Person("El Arbi"));
        entityManager.persist(new Person("Fatima"));
        entityManager.getTransaction().commit();

        //printing person table
        List<Person> people = listPersons(entityManager);
        people.forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();

    }

    static List<Person> listPersons(EntityManager entityManager) {
        List<Person> result = entityManager.createQuery("from Person", Person.class).getResultList();
        return result;
    }

}
