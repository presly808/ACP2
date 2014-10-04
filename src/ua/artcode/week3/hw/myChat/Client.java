package ua.artcode.week3.hw.myChat;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int serverPort = 9999;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("Connecting to " + address + ":" + serverPort);
            Socket socket = new Socket(ipAddress, serverPort);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String line = null;

            while (true){
                line = reader.readLine();
                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();
                line = dataInputStream.readUTF();
                System.out.println(line);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
