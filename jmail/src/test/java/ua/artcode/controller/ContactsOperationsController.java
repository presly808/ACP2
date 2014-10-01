package ua.artcode.controller;

import ua.artcode.model.Contacts.Contact;
import ua.artcode.model.Contacts.ContactsOperationsInterface;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by bm13 on 27.09.2014.
 */
public class ContactsOperationsController implements ContactsOperationsInterface {
    HashMap<Integer, Contact> contacts = new HashMap<Integer, Contact>();

    @Override
    public void add(String firstName, String lastName, String email) {
        Contact contact = new Contact(firstName, lastName, email);
        contacts.put(getNextContactId(),contact);
    }

    @Override
    public void edit(int id, String firstName, String lastName, String email) {
        Contact contact = contacts.get(id);
        contact.edit(firstName, lastName, email);
    }

    @Override
    public void delete(int id) {
        contacts.remove(id);

    }

    @Override
    public void print() {
        for (int i = 0; i <= contacts.size(); i++){
            Contact contact = contacts.get(Integer.valueOf(i));
                    contact.print();
        }
    }

    @Override
    public HashMap<Integer, Contact> getContactsList() {
        return contacts;
    }

    @Override
    public int getNextContactId() {
        return contacts.keySet().size() + 1;
    }
}
