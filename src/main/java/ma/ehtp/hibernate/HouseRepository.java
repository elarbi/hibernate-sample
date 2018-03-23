package ma.ehtp.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HouseRepository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dariPU");
    EntityManager em = entityManagerFactory.createEntityManager();


    public void addPerson(Person person) {
        em.getTransaction().begin();

        em.persist(person);

        em.getTransaction().commit();

    }

    public void addHouse(House house) {
        em.getTransaction().begin();

        em.persist(house);

        em.getTransaction().commit();

    }

}
