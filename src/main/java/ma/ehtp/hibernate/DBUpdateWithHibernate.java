package ma.ehtp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class DBUpdateWithHibernate {

    //https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

    public static void main(String[] args) throws SQLException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dariPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Person("El Arbi"));
        entityManager.persist(new Person("Fatima"));
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


    }


}
