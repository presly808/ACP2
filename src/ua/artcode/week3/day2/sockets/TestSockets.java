package ua.artcode.week3.day2.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestSockets {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("173.194.113.195", 80);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }

    }

}
