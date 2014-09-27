package ua.artcode.JMail.Team1.model;

/**
 * Created by bm13 on 27.09.2014.
 */
public interface MessageInterface {

    public int create(String from, String to, String subject, String body);
    public void send(int id);
    public void reply(int id);
    public void forward(int id, String to);
    public void delete(int id);
    public void setPriority(int priority);
    public void makeRead(int id);

}
