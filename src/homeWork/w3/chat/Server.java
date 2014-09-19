package homeWork.w3.chat;// Created by Sergey on 18.09.2014.

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        Scanner inPut;
        PrintWriter outPut;

        while (true){
            Socket socket = serverSocket.accept();
//            System.out.println(socket.getInetAddress().getCanonicalHostName());

            outPut = new PrintWriter(socket.getOutputStream());
//            inPut = new Scanner(socket.getInputStream());
            inPut = new Scanner(System.in);
            outPut.println(inPut.nextLine());
            outPut.flush();
        }
    }
}