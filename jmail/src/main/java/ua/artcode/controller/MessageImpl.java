package ua.artcode.controller;

import ua.artcode.model.Messages.MessageInterface;

/**
 * Created by bm13 on 27.09.2014.
 */
public class MessageImpl implements MessageInterface {
    @Override
    public int create(String from, String to, String subject, String body) {
        return 0;
    }

    @Override
    public void send(int id) {

    }

    @Override
    public void reply(int id) {

    }

    @Override
    public void forward(int id, String to) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void setPriority(int priority) {

    }

    @Override
    public void makeRead(int id) {

    }
}
