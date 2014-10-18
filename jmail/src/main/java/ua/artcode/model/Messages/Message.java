package ua.artcode.model.Messages;

import ua.artcode.model.Users.UserBean;

import java.util.List;

/**
 * Created by bm13 on 27.09.2014.
 */
public interface Message {

    public int create(UserBean from, List to, String subject, String body, MessagePriority priority, MessageType type, boolean markRead);
    public int create(UserBean from, List to, String subject, String body);
    public void send(int id);
    public void reply(int id, UserBean from, String body);
    public void replyAll(int id, UserBean from, String body);
    public void forward(int id,UserBean from, List to, String body);
    public void deleteToTrash(int id);
    public void deleteComletely(int id);
    public void changePriority(int id,MessagePriority priority);
    public void makeRead(int id);
    public MessageBean getMessage(int id);

}
