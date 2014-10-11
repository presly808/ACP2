package jmail.server.to;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 05.10.2014.
 */
public class RunServer {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(9999);
        while (true) {
            Socket socket = ss.accept();
            new Thread(new ClientThread(socket)).start();
        }


    }
}
