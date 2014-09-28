package my_tmp.MySockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Admin on 11.09.14.
 */
public class MySocket_2_Server implements Runnable{

    BufferedReader br;

    public static void main(String[] args) throws Exception {
        MySocket_2_Server server = new MySocket_2_Server();
        server.run();
    }

    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(444);
            while (true){
                Socket socket = serverSocket.accept();
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message = br.readLine();
                System.out.println(message);

                if (message != null) {
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    ps.println("message received!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
