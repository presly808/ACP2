package jmail.service;

import jmail.dao.LetterDao;
import jmail.dao.LetterDaoImpl;
import jmail.dao.UserDao;
import jmail.dao.UserDaoImpl;

/**
 * Created by admin on 04.10.2014.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private LetterDao letterDao = new LetterDaoImpl();

    @Override
    public void sendMessage(String to, String title, String body) {

    }
}
