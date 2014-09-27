package ua.artcode.week3.week3.HM.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 1 on 24.09.14.
 */
public class ServerSide {
    private ArrayList list = new ArrayList();
    //private BufferedReader reader;
    private PrintWriter writer;
    private ServerSocket serverSocket;

    public ServerSide() {
        try {
            serverSocket = new ServerSocket(9991);
            System.out.println("ServerSocket established!");
            iniciate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void iniciate() {
        try {
            while (true) {
                System.out.println("Waiting for income client!");
                Socket socket = serverSocket.accept();
                writer = new PrintWriter(socket.getOutputStream());
                String testM = "Server test message";
                writer.print(testM);
                System.out.println("Writer Added!");
                list.add(writer);
                Thread thread = new Thread(new MessageDelivery(socket));
                thread.start();
                System.out.println("New thread started!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private class MessageDelivery implements Runnable {
        Socket socketN;
        BufferedReader readerN;

        private MessageDelivery(Socket socket) {

            try {
                this.socketN = socket;

                this.readerN = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String msg = "";

            try {
                while ((msg = readerN.readLine())!=null){
                    System.out.println("Tell everyone loop");
                    tellEverypne(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void tellEverypne(String msg) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println("Message sent!");
            String testM = "Server test message";
            PrintWriter w = (PrintWriter)iterator.next();
            w.println(testM);
            w.flush();
        }

    }
}