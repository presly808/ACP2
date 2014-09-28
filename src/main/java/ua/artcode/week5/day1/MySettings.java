package ua.artcode.week5.day1;

public class MySettings {

    private String ipAddress;
    private int port;

    //@Mapped("server.user.limit)
    private int userLimit;

    public MySettings(String ipAddress, int port, int userLimit) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.userLimit = userLimit;
    }

    public MySettings() {
        ipAddress = "127.0.0.1";  //Hard code
        port = 9999;              //Hard code
        userLimit = 12;           //Hard code
    }



}
