package my_tmp.MySockets;

/**
 * Created by Admin on 11.09.14.
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MySocket_1_Client {
    //--------------------------------------------------------------------------------------
    public static void main(String[] args) throws Exception {
        MySocket_1_Client client = new MySocket_1_Client();
        client.run();
    }
    //--------------------------------------------------------------------------------------
    public void run() throws Exception {
        Socket sock = new Socket("localhost", 444);
        PrintStream ps = new PrintStream(sock.getOutputStream());
        ps.println("Hello to server from client");

        InputStreamReader isr = new InputStreamReader(sock.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        String message = br.readLine();
        System.out.println(message);
    }
    //--------------------------------------------------------------------------------------
}
