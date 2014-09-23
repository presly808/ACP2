package ua.artcode.week3.day2.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by admin on 07.09.2014.
 */
public class TestSocket {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("173.194.113.195", 8080);
        System.out.println(socket.isConnected());
        System.out.println();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        InputStream is = socket.getInputStream();

        //while(bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        //}

    }

}
