package ua.artcode.week3.day2.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 07.09.2014.
 */
public class MyServerSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        while(true){
            Socket socket = serverSocket.accept();//
            System.out.println(socket.getInetAddress().getCanonicalHostName());
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("Hello ua.artcode.week7.day2.rmi.remote");
            pw.flush();
        }
    }

}
