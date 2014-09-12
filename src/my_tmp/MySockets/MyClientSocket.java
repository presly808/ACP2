package my_tmp.MySockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Admin on 07.09.14.
 */
public class MyClientSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 444);
        Scanner sc = new Scanner(socket.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("Hello to server from client");
        while(sc.hasNext()){
            ps.println(br.readLine());
            String message = sc.nextLine();
            System.out.println(message);

        }
    }
}
