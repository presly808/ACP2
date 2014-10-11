package jmail.server.to;

import jmail.model.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 05.10.2014.
 */
public class TransferObject implements Serializable {

    private String accessKey;
    private String login;
    private String pass;
    private String action; //todo replace by enum
    /*
    * Map for transfer data, like user, letter
    * ex. key=letter_tittle value=Some letter title
    *     key=letter_body   value=Hi my friend, how are you?
    * */
    public Map<String, Object> map = new HashMap<>(32);

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
