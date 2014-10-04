package ua.artcode.controller;

import sun.util.calendar.Gregorian;
import sun.util.calendar.LocalGregorianCalendar;
import ua.artcode.model.Messages.MessageInterface;
import ua.artcode.model.Users.UserInterface;

/**
 * Created by bm13 on 27.09.2014.
 */
public class MessageImpl implements MessageInterface {

    private UserInterface from;
    private UserInterface to;
    private String subject;
    private String body;
    private Gregorian date;
    private MessagePriority priority;
    private boolean isSend;

    public MessageImpl(UserInterface from, UserInterface to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        date = LocalGregorianCalendar.getGregorianCalendar();
    }

    @Override
    public int create(UserInterface from, UserInterface to, String subject, String body) {
        int newID = from.getListOfMessages().size()+1;
        from.getListOfMessages().put(newID, new MessageImpl(from, to, subject, body));
        return newID;
    }

    @Override
    public void send(int id) {

    }

    @Override
    public int reply(UserInterface user, int id, String body) {
        int newId = user.getListOfMessages().size()+1;
        String newSubject = "Re: " + user.getListOfMessages().get(id).getSubject();
        String newBody = body + "\n\n\"" + user.getListOfMessages().get(id).getBody() + "\"";
        UserInterface newTo = user.getListOfMessages().get(id).getFrom();;
        UserInterface newFrom = user.getListOfMessages().get(id).getTo();
        user.getListOfMessages().put(newId, new MessageImpl(newTo, newFrom, newSubject, newBody);
        return newId;
    }

    @Override
    public void forward(UserInterface user, int id, UserInterface[] to) {
        int newId;
        String newSubject = "Forvard from: " + user.getListOfMessages().get(id).getFrom() + " " user.getListOfMessages().get(id).getSubject();
        String newBody = user.getListOfMessages().get(id).getBody();
        for (int i = 0; i < to.length; i++){
            newId = user.getListOfMessages().size()+1;
            user.getListOfMessages().put(newId, new MessageImpl(user, to[i], newSubject, newBody));
        }
    }

    @Override
    public void delete(UserInterface user, int id) {
        user.getListOfMessages().remove(id);
    }

    @Override
    public void setPriority(int priority) {
        switch (priority){
            case 0:
                this.priority = MessagePriority.NORMAL;
                break;
            case 1:
                this.priority = MessagePriority.IMPORTANT;
                break;
            case 2:
                this.priority = MessagePriority.VIM;
                break;
            default:
                this.priority = MessagePriority.NORMAL;
        }
    }

    @Override
    public void makeRead(int id) {

    }

    public UserInterface getFrom() {
        return from;
    }

    public UserInterface getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Gregorian getDate() {
        return date;
    }

    public MessagePriority getPriority() {
        return priority;
    }
}
