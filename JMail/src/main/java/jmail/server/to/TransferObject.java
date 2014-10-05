package jmail.server.to;

import jmail.model.User;

import java.io.Serializable;

/**
 * Created by admin on 05.10.2014.
 */
public class TransferObject implements Serializable {

    private String accessKey;
    private String login;
    private String pass;
    private String action; //todo replace by enum

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

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
