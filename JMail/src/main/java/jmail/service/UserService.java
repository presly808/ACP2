package jmail.service;

import jmail.model.Letter;
import jmail.model.User;

import java.util.List;

/**
 * Created by admin on 28.09.2014.
 */
public interface UserService {

    public void sendMessage(String from, String to, String title, String body);

    public List getUnreadLetters(String login);

    public List<Letter> allLettersByUserLogin();

    public void registerUser(String login, String pass);

    public void singIn(String login, String pass);


}