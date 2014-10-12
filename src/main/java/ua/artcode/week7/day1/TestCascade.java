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
public class TestCascade {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        Author author = new Author("Viktor3", 30, 20000, new Date());
        for (int i = 0; i < 10; i++) {
            Book e = new Book("SOME-" + i, "DESC-" + i);
            e.setAuthor(author);
            author.getBooks().add(e);
        }

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(author);
        transaction.commit();
        entityManager.clear();



        System.out.println();

    }
}
