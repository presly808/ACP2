package my_tmp.MySockets;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Admin on 25.09.14.
 */
public class MySocket_2_Server_Run implements Runnable {

    Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    String string;

    public MySocket_2_Server_Run(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
