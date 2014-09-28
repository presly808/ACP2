package ua.artcode.model;

import java.util.HashMap;

/**
 * Created by bm13 on 27.09.2014.
 */
public interface OperationsInterface {

    public HashMap<Integer, Message> getAllMessages();
    public HashMap<Integer, Message> getContactsList();

}
