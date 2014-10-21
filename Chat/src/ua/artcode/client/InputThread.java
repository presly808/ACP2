package ua.artcode.client;

import ua.artcode.transfer.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Created by admin on 21.10.2014.
 */
public class InputThread implements Runnable {

    private InputStream inputStream;

    public InputThread(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        while (true){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Message message = (Message) objectInputStream.readObject();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
}
