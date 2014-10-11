package jmail;

import jmail.util.DBConnectionFactory;

import java.io.File;
import java.sql.SQLException;

/**
 * Created by admin on 05.10.2014.
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        DBConnectionFactory.getConnection();
        System.out.println(new File("db.properties").exists());
    }
}
