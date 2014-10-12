package ua.artcode.week7.day1;

import ua.artcode.week7.day1.entities.Address;
import ua.artcode.week7.day1.entities.Author;
import ua.artcode.week7.day1.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Created by admin on 12.10.2014.
 */
public class TestJPARemove {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();
        entityManager.clear();

        Author author1 = entityManager.find(Author.class, 3);

        System.out.println();

    }


}
