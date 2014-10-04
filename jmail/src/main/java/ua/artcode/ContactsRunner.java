package ua.artcode;

import ua.artcode.controller.ContactsOperationsImpl;

/**
 * Created by bm13 on 27.09.2014.
 */
public class ContactsRunner {
    public static void main(String[] args) {

        ContactsOperationsImpl contactsController = new ContactsOperationsImpl();

        for (int i = 0; i < 10; i++){
            String name = "Name"+i;
            String surname = "Surname"+i;
            String email = name+"."+surname+"@domain.com";
            contactsController.add(name,surname,email);
        }

        contactsController.print();

        int last = contactsController.getContactsList().size()-1;

        contactsController.edit(last,"The","Last","the@last");

        contactsController.print();

        contactsController.delete(last);

        contactsController.print();

    }
}
