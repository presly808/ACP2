package ua.artcode.week7.day1;

import org.hibernate.Transaction;
import ua.artcode.week7.day1.entities.Address;
import ua.artcode.week7.day1.entities.Author;
import ua.artcode.week7.day1.entities.Book;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 11.10.2014.
 */
public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my_unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //NEW, MANAGED, DELETED, DETACHED
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

        //Java Persistence Query Language
        Query query = entityManager.createQuery
                ("SELECT a FROM Author a WHERE a.name = :name");
        List<Author> list = query.setParameter("name", "Anton").getResultList();
        for(Author author1 : list){
            System.out.println(author1);
            Address address1 = author1.getAddress();
            System.out.println(address1);
        }


    }
}
