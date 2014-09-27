package ua.artcode.JMail.Team1.model;

/**
 * Created by bm13 on 27.09.2014.
 */
public interface ContactsInterface {

    public int add(String firstName, String lastName, String email);
    public void edit(int id, String firstName, String lastName, String email);
    public void delete(int id);

}
