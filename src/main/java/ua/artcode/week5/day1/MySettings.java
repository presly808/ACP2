package ua.artcode.week5.day1;

/**
 * Created by admin on 27.09.2014.
 */
public class MySettings {


    private String ipAddress;

    private int port;

    private int usersLimit;

    public MySettings(String ipAddress, int port, int usersLimit) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.usersLimit = usersLimit;
    }

    public MySettings() {
        ipAddress = "127.0.0.1";
        port = 9999;
        usersLimit = 12;

    }
}


