package ua.artcode.transfer;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Message implements Serializable {

    private String title;
    private String body;
    private String from;
    private Date date;

    public Message(String title, String body, String from, Date date) {
        this.title = title;
        this.body = body;
        this.from = from;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", from='" + from + '\'' +
                ", date=" + date +
                '}';
    }
}
