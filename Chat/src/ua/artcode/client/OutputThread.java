package ua.artcode.client;

import ua.artcode.transfer.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by admin on 21.10.2014.
 */
public class OutputThread implements Runnable {

    public OutputStream outputStream;

    public OutputThread(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            while (true){
                String str = scanner.nextLine();
                Message message = new Message(null, str, Thread.currentThread().getName(), new Date());
                oos.writeObject(message);
                oos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }



    }
}
