package jmail.service;

import jmail.model.User;

import java.util.List;

/**
 * Created by admin on 28.09.2014.
 */
public interface UserService {

    public List<User> getAllContacts(String login);

}
