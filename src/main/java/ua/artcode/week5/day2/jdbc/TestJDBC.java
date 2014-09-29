package ua.artcode.week5.day2.jdbc;


import java.sql.*;

/**
 * Created by admin on 28.09.2014.
 */
public class TestJDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // load driver class into JVM
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jmail", "root", "root");
        insertUser(connection, "Nikita", "1111", "+2312312");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user;");
        while(resultSet.next()){
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(1));
        }
        statement.close();
        connection.close();

    }

    public static void insertUser(Connection connection ,String login, String pass, String phone){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = String.format("INSERT INTO user VALUES ('%s', '%s', '%s')", login, pass, phone);
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
