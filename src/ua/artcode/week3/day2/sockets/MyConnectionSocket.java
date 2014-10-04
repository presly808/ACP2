package ua.artcode.week3.day2.sockets;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyConnectionSocket {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.33", 9999);
        Scanner scanner = new Scanner(socket.getInputStream());
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }

}
