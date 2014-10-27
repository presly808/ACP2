package jmail.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//REPLACED by org.springframework.web.context.ContextLoaderListener
//see web.xml
public class SpringContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ap =
                new ClassPathXmlApplicationContext("classpath:app-context.xml");
        sce.getServletContext().setAttribute("springContext", ap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
