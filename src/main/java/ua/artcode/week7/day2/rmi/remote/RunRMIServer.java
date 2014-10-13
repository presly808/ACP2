package ua.artcode.week7.day2.rmi.remote;

/**
 * Created by admin on 12.10.2014.
 */
public class RunRMIServer {
    public static void main(String[] args) {
        new Thread(new RemoteDispatcher(new CommonInterfaceImpl())).start();
    }

}
