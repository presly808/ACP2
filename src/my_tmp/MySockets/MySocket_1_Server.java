package my_tmp.MySockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Admin on 11.09.14.
 */
public class MySocket_1_Server {
    //--------------------------------------------------------------------------------------
    public static void main(String[] args) throws Exception {
        MySocket_1_Server server = new MySocket_1_Server();
        server.run();
    }
    //--------------------------------------------------------------------------------------
    public void run() throws Exception {
        ServerSocket serverSocket = new ServerSocket(444);
        Socket socket = serverSocket.accept();

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        String message = br.readLine();
        System.out.println(message);

        if (message != null) {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("message received!");
        }




    }
    //--------------------------------------------------------------------------------------
}
