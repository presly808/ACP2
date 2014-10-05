package jmail.server.to;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by admin on 05.10.2014.
 */
public class ClientThread implements Runnable {

    private Socket client;


    public ClientThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            is = client.getInputStream();
            ois = new ObjectInputStream(is);
            while (true) {
                TransferObject to = (TransferObject) ois.readObject();
                String action = to.getAction();
                System.out.println(action);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
