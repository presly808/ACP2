package ua.artcode.model.Contacts;

/**
 * Created by bm13 on 27.09.2014.
 */
public interface Contact {

    public void add(String firstName, String lastName, String email);
    public void edit(int id, String firstName, String lastName, String email);
    public void delete(int id);
    public void print();
    public ContactBean getContact(int id);

}
