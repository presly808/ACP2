package ua.artcode.week3.week3.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 1 on 07.09.14.
 */
public class ConnectionSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.33",9999);
        Scanner scanner = new Scanner(socket.getInputStream());
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }


    }
}
