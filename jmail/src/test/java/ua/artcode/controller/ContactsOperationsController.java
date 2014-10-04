package ua.artcode.controller;

import ua.artcode.model.Contacts.ContactImpl;
import ua.artcode.model.Contacts.ContactsOperationsInterface;

import java.util.HashMap;

/**
 * Created by bm13 on 27.09.2014.
 */
public class ContactsOperationsController implements ContactsOperationsInterface {
    HashMap<Integer, ContactImpl> contacts = new HashMap<Integer, ContactImpl>();

    @Override
    public void add(String firstName, String lastName, String email) {
        ContactImpl contact = new ContactImpl(firstName, lastName, email);
        contacts.put(getNextContactId(),contact);
    }

    @Override
    public void edit(int id, String firstName, String lastName, String email) {
        ContactImpl contact = contacts.get(id);
        contact.edit(firstName, lastName, email);
    }

    @Override
    public void delete(int id) {
        contacts.remove(id);

    }

    @Override
    public void print() {
        for (int i = 0; i <= contacts.size(); i++){
            ContactImpl contact = contacts.get(Integer.valueOf(i));
                    contact.print();
        }
    }

    @Override
    public HashMap<Integer, ContactImpl> getContactsList() {
        return contacts;
    }

    @Override
    public int getNextContactId() {
        return contacts.keySet().size() + 1;
    }
}
