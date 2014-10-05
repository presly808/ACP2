package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;
import jmail.service.UserService;
import jmail.service.UserServiceImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

/**
 * Created by admin on 04.10.2014.
 */
public class LetterDaoTest {

    private UserDao userDao = new UserDaoImpl();
    private LetterDao letterDao = new LetterDaoImpl();

    private User user1 = null;
    private User user2 = null;

    //todo think about id of user
    @Before
    public void addUsers(){
        user1 = new User(1,"ricky8", "1234");
        user2 = new User(2, "vova22", "1234");
        userDao.create(user1);
        userDao.create(user2);

    }

    @Test
    public void testCreateLetter(){
        letterDao.create(
                new Letter("testTitle", "some text", user1, user2, new Date()));
    }





}
