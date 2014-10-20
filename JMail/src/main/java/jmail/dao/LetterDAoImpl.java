package jmail.dao;

import jmail.model.Letter;
import jmail.model.User;
import jmail.util.DBConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 04.10.2014.
 */
public class LetterDAoImpl implements LetterDao {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public Letter findById(int id) {
        return null;
    }

    @Override
    public Letter findByDateRange(Date start, Date end) {
        return null;
    }

    @Override
    public List<Letter> findByKeyWord(String keyWord) {
        return null;
    }

    @Override
    public void create(Letter letter) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            statement =  connection.createStatement();
            String query = String.format(
                    "INSERT INTO letters (title, body, to_user, from_user, send_date) VALUES " +
                            "('%s', '%s', '%s', '%s', '%s')", letter.getTitle(), letter.getBody(), letter.getTo().getId(),
                    letter.getFrom().getId(), new java.sql.Date(System.currentTimeMillis()).toString());
                    statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Letter letter) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Letter> allByUserLogin(String login) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBConnectionFactory.getConnection();
            //statement =  connection.createStatement();
            statement = connection.prepareStatement("SELECT * FROM letters as l, users as u WHERE u.login=? AND\n" +
                                                            "(l.from_user=u.user_id OR l.to_user=u.user_id);");
            statement.setString(1, login);
            //todo write valid query for select
            ResultSet resultSet = statement.executeQuery();
            List<Letter> letters = new ArrayList<>();
            while (resultSet.next()){
                int letterId = resultSet.getInt("letter_id");
                String title = resultSet.getString("title");
                String body  = resultSet.getString("body");
                Date date = resultSet.getDate("send_date");
                User userTo = userDao.findById(resultSet.getInt("to_user"));
                User userFrom = userDao.findById(resultSet.getInt("from_user"));
                Letter letter = new Letter(letterId, title, body, userTo, userFrom, date);
                letters.add(letter);
            }
            return letters;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
