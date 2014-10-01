package ua.artcode.model.Contacts;

import java.util.HashMap;

/**
 * Created by bm13 on 27.09.2014.
 */
public interface ContactsOperationsInterface {

    public void add(String firstName, String lastName, String email);
    public void edit(int id, String firstName, String lastName, String email);
    public void delete(int id);
    public void print();
    public int getNextContactId();

    public HashMap<Integer, Contact> getContactsList();



}
