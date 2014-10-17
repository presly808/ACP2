package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 04.10.2014.
 */
@FixMethodOrder(MethodSorters.DEFAULT)
public class GeneralIntegrationTests {

    private static UserDao userDao = new UserDaoImpl();
    private static LetterDao letterDao = new LetterDAoImpl();

    private static User user1 = null;
    private static User user2 = null;

    //todo think about id of user
    @BeforeClass
    public static void init(){
        String loginUser1 = UUID.randomUUID().toString(); // for generate random value
        String loginUser2 = UUID.randomUUID().toString();
        user1 = userDao.create(new User(loginUser1, "1234"));
        user2 = userDao.create(new User(loginUser2, "1234"));
        Assert.assertNotNull(userDao.find(user1.getLogin()));
        Assert.assertNotNull(userDao.find(user2.getLogin()));
    }

    @Test
    public void _2_createLetter(){
        letterDao.create(
                new Letter("testTitle1", "some text u1 - u2", user1, user2, new Date()));
        letterDao.create(
                new Letter("testTitle2", "some text u2 - u1", user2, user1, new Date()));
    }

    @Test
    public void _3_testAllLetters(){
        List<Letter> letterList = letterDao.allByUserLogin(user1.getLogin());
        Assert.assertEquals(2, letterList.size());
    }





}
