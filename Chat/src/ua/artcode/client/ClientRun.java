package ua.artcode.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by admin on 21.10.2014.
 */
public class ClientRun {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 9999);
        new Thread(new InputThread(socket.getInputStream())).start();
        new Thread(new OutputThread(socket.getOutputStream())).start();

    }
}
