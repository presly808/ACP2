package ua.artcode.week3.hw.myChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 9999;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a client...");
            Socket socket = serverSocket.accept();
            System.out.println("Got a client!");
            System.out.println();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream); //If we need send message from server to client

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line = null;
            while (true){
                line = dataInputStream.readUTF();
                System.out.println(line);
                line = reader.readLine();
                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
