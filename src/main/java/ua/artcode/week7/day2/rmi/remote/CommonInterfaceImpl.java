package ua.artcode.week7.day2.rmi.remote;

/**
 * Created by admin on 12.10.2014.
 */
public class CommonInterfaceImpl implements CommonInterface {
    @Override
    public String getMessage() {
        return "Message from server";
    }
}
