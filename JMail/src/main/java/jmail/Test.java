package jmail;

import jmail.service.UserService;
import jmail.util.DBConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.sql.SQLException;

/**
 * Testing init Spring context, now without declarative transactions(Spring Transaction Manager)
 */
public class Test {

    public static void main(String[] args) throws SQLException {
        ApplicationContext ap = new ClassPathXmlApplicationContext("classpath:app-context.xml");
        UserService userService = (UserService) ap.getBean("userService");
        userService.registerUser("Vasia", "1234");
    }
}
