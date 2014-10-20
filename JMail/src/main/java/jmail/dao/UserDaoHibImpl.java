package jmail.dao;

import jmail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by admin on 19.10.2014.
 */
@Repository
public class UserDaoHibImpl implements UserDao {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public User findById(int id) {
        EntityManager entityManager = factory.createEntityManager();
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User find(String login) {
        return null;
    }

    @Override
    @Transactional
    public User create(User user) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(String login) {
        return false;
    }

    @Override
    public List<User> all() {
        return null;
    }
}
