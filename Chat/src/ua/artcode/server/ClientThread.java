package ua.artcode.server;

import ua.artcode.transfer.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Created by admin on 21.10.2014.
 */
public class ClientThread implements Runnable {

    private InputStream inputStream;
    private OutStreamsContainer oosContainer;

    public ClientThread(InputStream inputStream, OutStreamsContainer oosContainer) {
        this.inputStream = inputStream;
        this.oosContainer = oosContainer;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            while (true) {
                Message message = (Message) objectInputStream.readObject();
                oosContainer.notifyAllClients(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
