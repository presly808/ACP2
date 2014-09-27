package ua.artcode.week3.week3.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by 1 on 07.09.14.
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("173.194.113.195", 80);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;


    }
}
