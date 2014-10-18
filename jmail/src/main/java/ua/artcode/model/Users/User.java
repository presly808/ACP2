package ua.artcode.model.Users;

/**
 * Created by bm13 on 27.09.2014.
 */
public interface User {
    public void add(String login, String password, UserPrivileges privileges);
    public void add(String login, String password);
    public boolean authenticate();
    public boolean authorize(String login, String password);
    public void edit(String login, String password, UserPrivileges privileges);
    public void edit(String login, String password);
    public int findId(String login);
    public UserBean getUser(String login);
    public UserBean getUser(int id);
    public void delete(int id);
    public void delete(String login);
}
