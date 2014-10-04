package ua.artcode.controller;

import ua.artcode.model.Contacts.ContactInterface;

/**
 * Created by bm13 on 27.09.2014.
 */
public class ContactImpl implements ContactInterface {
    private String firstName;
    private String lastName;
    private String email;

    public ContactImpl(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void edit(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
