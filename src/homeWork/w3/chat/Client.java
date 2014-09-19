package homeWork.w3.chat;// Created by Sergey on 18.09.2014.

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",9999);

        Scanner inPut = new Scanner(socket.getInputStream());
        PrintWriter outPut;

        while(inPut.hasNext()){
            outPut = new PrintWriter(socket.getOutputStream());
            System.out.println(inPut.nextLine());
            outPut.println();
            outPut.flush();
        }
    }
}