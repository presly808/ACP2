package ua.artcode.dao;

import java.sql.*;

/**
 * Created by bm13 on 03.10.2014.
 */
public class DBDao {

    private static String DB_URL;
    private static String USER;
    private static String PASS;
    private static Connection connection = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static void initDB(String ip, String port, String schema, String USER, String PASS) throws ClassNotFoundException, SQLException {
        DB_URL = String.format("jdbc:mysql://%s:%s/%s",ip,port,schema);

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Connecting to database...");
        connection = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("Connected to database...");

        testSelect();
    }

    public static void testSelect() throws SQLException {

        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");
        while (rs.next()) {
            System.out.println(String.format("%d %s %s %s",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
        }
        rs.close();
        stmt.close();

    }

}
