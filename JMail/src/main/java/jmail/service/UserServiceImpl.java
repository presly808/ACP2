package jmail.service;

import jmail.dao.LetterDAoImpl;
import jmail.dao.LetterDao;
import jmail.dao.UserDao;
import jmail.dao.UserDaoImpl;
import jmail.model.Letter;
import jmail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 04.10.2014.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private LetterDao letterDao;

    @Override
    public void sendMessage(String from ,String to, String title, String body) {
        User toUser = userDao.find(to);
        User fromUser = userDao.find(from);
        Letter letter = new Letter(title, body, toUser, fromUser, new Date());
        letterDao.create(letter);
    }

    @Override
    public List getUnreadLetters(String login) {
        return null;
    }

    @Override
    public List<Letter> allLettersByUserLogin() {
        return null;
    }

    @Override
    @Transactional
    public void registerUser(String login, String pass) {
        User user = new User(login, pass);
        userDao.create(user);
    }

    @Override
    public void singIn(String login, String pass) {

    }
}
