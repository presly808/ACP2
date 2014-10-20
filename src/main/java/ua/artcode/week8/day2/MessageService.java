package ua.artcode.week8.day2;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 19.10.2014.
 */
public class MessageService implements IService {

    @Override
    public String getMessage() {
        return "MESSAGE_SERVICE";
    }
}
