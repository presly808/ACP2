package ua.artcode.server;

import java.io.OutputStream;
import java.util.LinkedList;

/**
 * Created by admin on 21.10.2014.
 */
public class ServerRun {


    public static void main(String[] args) {
        OutStreamsContainer oosContainer = new OutStreamsContainer(new LinkedList<OutputStream>());
        new Thread(new ServerThread(oosContainer)).start();
    }
}
