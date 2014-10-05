package jmail.server.to;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by admin on 05.10.2014.
 */
public class ClientRun {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1",9999);
        TransferObject transferObject = new TransferObject();
        transferObject.setAction("Action from client");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        while (true){
            oos.writeObject(transferObject);
            oos.flush();
            Thread.sleep(1200);
        }
    }
}
