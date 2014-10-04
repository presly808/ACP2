package ua.artcode.model.Messages;

import ua.artcode.controller.MessageImpl;

import java.util.HashMap;

/**
 * Created by bm13 on 27.09.2014.
 */
public interface MessagesOperationsInterface {

    public HashMap<Integer, MessageImpl> getAllMessages();
}
