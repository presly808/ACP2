package jmail.service;

import jmail.dao.LetterDao;
import jmail.dao.UserDao;

/**
 * Created by admin on 04.10.2014.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private LetterDao letterDao;


    @Override
    public void sendMessage(String to, String title, String body) {

    }
}
