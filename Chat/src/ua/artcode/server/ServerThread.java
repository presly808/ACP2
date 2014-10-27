package ua.artcode.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 21.10.2014.
 */
public class ServerThread implements Runnable {

    private OutStreamsContainer outStreamsContainer;

    public ServerThread(OutStreamsContainer outStreamsContainer) {
        this.outStreamsContainer = outStreamsContainer;
    }

    @Override
    public void run() {

        try {
            ServerSocket ss = new ServerSocket(9999);
            while (true){
                Socket socket = ss.accept();
                outStreamsContainer.addOutputStream(socket.getOutputStream());
                new Thread(new ClientThread(socket.getInputStream(), outStreamsContainer)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
