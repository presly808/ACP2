package ua.artcode.week3.day2.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by admin on 07.09.2014.
 */
public class MyConnectionSocket {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.33", 9999);
        Scanner sc = new Scanner(socket.getInputStream());
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
