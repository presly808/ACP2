package ua.artcode.week7.day2.rmi.remote;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by admin on 12.10.2014.
 */
public class RemoteProxy implements CommonInterface {
    @Override
    public String getMessage() {
        String res = null;
        try {
            Socket socket = new Socket("127.0.0.1",9999);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("getMessage");
            pw.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            res = (String) ois.readObject();

            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }
}
