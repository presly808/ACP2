package my_tmp.MySockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Admin on 07.09.14.
 */
public class MyClientSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.33", 9999);
        Scanner sc = new Scanner(socket.getInputStream());
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
    }
}
