package jmail.service;

import jmail.dao.LetterDao;
import jmail.dao.LetterDaoImpl;
import jmail.dao.UserDao;
import jmail.dao.UserDaoImpl;
import jmail.model.Letter;
import jmail.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 04.10.2014.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private LetterDao letterDao = new LetterDaoImpl();

    @Override
    public void sendMessage(String from ,String to, String title, String body) {
        User toUser = userDao.find(to);
        User fromUser = userDao.find(from);
        Letter letter = new Letter(title, body, toUser, fromUser, new Date());
        letterDao.create(letter);
    }

    @Override
    public List<Letter> allLettersByUserLogin() {
        return null;
    }
}
