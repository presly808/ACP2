package ua.artcode.model.Request;

import java.io.Serializable;

/**
 * Created by 1 on 05.10.14.
 */
public class RequestObject implements RequestInterface,Serializable {
    private ActionList action;
    private String login;
    private String password;
    private Object object;

    public ActionList getAction() {
        return action;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Object getObject() {
        return object;
    }

    public RequestObject(ActionList action, String login, String password, Object object) {
        this.action = action;
        this.login = login;
        this.password = password;
        this.object = object;
    }
}
