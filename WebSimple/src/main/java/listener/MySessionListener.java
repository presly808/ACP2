package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by admin on 26.10.2014.
 */
public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SESSION CREATED");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SESSION TERMINATED");
    }
}
