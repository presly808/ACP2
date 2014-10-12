package ua.artcode.week7.day1;

import sun.invoke.util.Wrapper;
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
public class TestFetchType {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        Author author = new Author("Anton", 30, 20000, new Date());
        Address address = new Address("UKRAINE", "KIEV", "Ush 34");
        Book book = new Book("Old sea", "book about see");
        author.setAddress(address);
        author.getBooks().add(book);
        book.setAuthor(author);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(author);
        entityManager.persist(book);
        entityManager.persist(address);
        transaction.commit();
        entityManager.clear();

        Author author1 = entityManager.find(Author.class, 3);

        System.out.println();


    }


}
