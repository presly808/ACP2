package ua.artcode.week3.week3.HM.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 1 on 10.09.14.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
           Toto t = new Toto();
        for (int i = 0; i < 5; i++) {
            t.gogo();
            Thread.sleep(500);
        }
           //Client c = new Client();



    }
}
