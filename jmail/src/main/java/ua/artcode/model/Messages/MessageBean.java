package ua.artcode.model.Messages;

import ua.artcode.model.Users.UserBean;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bm13 on 27.09.2014.
 */
@Entity(name = "Messages")
@NamedQueries({
        @NamedQuery(name = "Messages.GetMessageById", query = "select m from Messages m where m.id=:id"),
        @NamedQuery(name = "Messages.MessagesOfUser", query = "select m from Messages m where m.to in (:recipientList)")
})

public class MessageBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(targetEntity = UserBean.class)
    private UserBean from;
    @Column(nullable = false)
    @OneToMany(targetEntity = UserBean.class)
    private List to;
    private String subject;
    private String body;
    @Enumerated(EnumType.STRING)
    private MessageType type;
    @Enumerated(EnumType.STRING)
    private MessagePriority priority;
    private boolean markRead;

    public MessageBean(UserBean from, List to, String subject, String body, MessagePriority priority, MessageType type, boolean markRead) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.priority = priority;
        this.markRead = markRead;
    }

    public MessageBean(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public UserBean getFrom() {
        return from;
    }

    public void setFrom(UserBean from) {
        this.from = from;
    }

    public List getTo() {
        return to;
    }

    public void setTo(List to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public void setPriority(MessagePriority priority) {
        this.priority = priority;
    }

    public boolean isMarkRead() {
        return markRead;
    }

    public void setMarkRead(boolean read) {
        this.markRead = read;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
