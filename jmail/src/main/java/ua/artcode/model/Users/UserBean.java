package ua.artcode.model.Users;

import ua.artcode.model.Contacts.ContactBean;

import javax.persistence.*;

import java.util.List;

/**
 * Created by bm13 on 27.09.2014.
 */
@Entity(name = "Users")
@NamedQueries({
@NamedQuery(name = "Users.selectByLoginAndPassword", query = "select u from Users u where u.login=:login and u.password=:password"),
@NamedQuery(name = "Users.selectByLogin", query = "select u from Users u where u.login=:login"),
@NamedQuery(name = "Users.selectById", query = "select u from Users u where u.id=:id"),
@NamedQuery(name = "Users.updateLoginPasswordPrivileges", query = "update Users u set u.login=:login,u.password=:password,u.privileges=:privileges")})

public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false,unique = true)
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserPrivileges privileges;
    @OneToMany(targetEntity = ContactBean.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List contactsList;

    public UserBean(){

    }

    public UserBean(String login, String password, UserPrivileges privileges, List contactsList) {
        this.login = login;
        this.password = password;
        this.privileges = privileges;
        this.contactsList = contactsList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserPrivileges getPrivileges() {
        return privileges;
    }

    public void setPrivileges(UserPrivileges privileges) {
        this.privileges = privileges;
    }

    public List getContactsList() {
        return contactsList;
    }

    public void setContactsList(List contactsList) {
        this.contactsList = contactsList;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", privileges='" + privileges + '\'' +
                ", contactsList=" + contactsList +
                '}';
    }
}
