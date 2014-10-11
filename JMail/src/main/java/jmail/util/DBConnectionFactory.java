package jmail.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by admin on 04.10.2014.
 */
//TODO refactor, do singleton or ...
public class DBConnectionFactory {

    private final String HOST;
    private final String PORT;
    private final String USER;
    private final String PASS;
    private static DBConnectionFactory INSTANCE = null;

    public DBConnectionFactory(String HOST, String PORT, String USER, String PASS) {
        this.HOST = HOST;
        this.PORT = PORT;
        this.USER = USER;
        this.PASS = PASS;
    }

    public static Connection getConnection() throws SQLException {
        if(INSTANCE == null){
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream("JMail/src/main/resources/db.properties"));
                String host = properties.getProperty("db.host");
                String port = properties.getProperty("db.port");
                String user = properties.getProperty("db.user");
                String pass = properties.getProperty("db.pass");
                INSTANCE = new DBConnectionFactory(host, port, user, pass);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", INSTANCE.HOST, INSTANCE.PORT, "jmail"),
                INSTANCE.USER, INSTANCE.PASS);
    }



}
