package ua.artcode.week8.day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 18.10.2014.
 */
public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:week8/application-context.xml");
        Employee employee = (Employee) applicationContext.getBean("empl1");
        System.out.println(employee);
    }
}
