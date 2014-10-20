package ua.artcode.week8.day2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 19.10.2014.
 */
public class TestDI {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:week8/application-context.xml");
        Client client = (Client) applicationContext.getBean("client");
        System.out.println(client.getiService().getMessage());


    }

}
