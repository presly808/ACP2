package jmail.dao;

import jmail.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by admin on 20.10.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-context.xml"})
public class UserDaoHibTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private LetterDao letterDao;

    private User user1 = null;
    private User user2 = null;

    //todo think about id of user
    @Test
    public void addUser(){
        String loginUser1 = UUID.randomUUID().toString(); // for generate random value
        String loginUser2 = UUID.randomUUID().toString();
        user1 = userDao.create(new User(loginUser1, "1234"));
        user2 = userDao.create(new User(loginUser2, "1234"));
        Assert.assertNotNull(userDao.findById(user1.getId()));
        Assert.assertNotNull(userDao.findById(user2.getId()));
    }



}
