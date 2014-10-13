package ua.artcode.week7.day2.rmi.remote;

/**
 * Created by admin on 12.10.2014.
 */
public class TestRMIClient {


    public static void main(String[] args) {
        CommonInterface commonInterface = new RemoteProxy();
        System.out.println(commonInterface.getMessage());
    }

}
