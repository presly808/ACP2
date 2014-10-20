package jmail.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by admin on 28.09.2014.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String pass;

    @OneToMany(mappedBy = "to")
    private List<Letter> send;

    @OneToMany(mappedBy = "from")
    private List<Letter> received;

    public User() {
    }

    public User(int id, String login, String pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Letter> getSend() {
        return send;
    }

    public void setSend(List<Letter> send) {
        this.send = send;
    }

    public List<Letter> getReceived() {
        return received;
    }

    public void setReceived(List<Letter> received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
