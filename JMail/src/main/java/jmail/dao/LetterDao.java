package jmail.dao;

import jmail.model.Letter;

import java.util.List;

/**
 * Created by admin on 04.10.2014.
 */
public interface LetterDao {


    public void create(Letter letter);

    public List<Letter> allByUserLogin(String login);



}
