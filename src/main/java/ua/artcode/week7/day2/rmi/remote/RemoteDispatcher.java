package ua.artcode.week7.day2.rmi.remote;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by admin on 12.10.2014.
 */
public class RemoteDispatcher  implements  Runnable {

    private CommonInterface commonInterface;

    public RemoteDispatcher(CommonInterface commonInterface) {
        this.commonInterface = commonInterface;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9999);
            Socket socket = ss.accept();
            Scanner sc = new Scanner(socket.getInputStream());
            while(!sc.hasNextLine()){

            }

            String command = sc.nextLine();

            Object res = null;

            if("getMessage".equals(command)){
                res = commonInterface.getMessage();
            }

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(res);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
