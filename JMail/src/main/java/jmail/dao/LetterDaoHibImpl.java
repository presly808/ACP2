package jmail.dao;

import jmail.model.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 19.10.2014.
 */
@Repository
public class LetterDaoHibImpl implements LetterDao {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public Letter findById(int id) {
        return null;
    }

    @Override
    public Letter findByDateRange(Date start, Date end) {
        return null;
    }

    @Override
    public List<Letter> findByKeyWord(String keyWord) {
        return null;
    }

    @Override
    public void create(Letter letter) {

    }

    @Override
    public void update(Letter letter) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Letter> allByUserLogin(String login) {
        return null;
    }
}
