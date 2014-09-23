package my_tmp.MyChat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class My_Chat_Server {
    //Global
    public static ArrayList<Socket> connectionArray = new ArrayList<Socket>();
    public static ArrayList<String> currentUsers = new ArrayList<String>();

public static void main(String[] args) throws IOException {
    try {
        final int PORT = 444;
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Waiting for clients...");

        while (true){
            Socket socket = server.accept();
            connectionArray.add(socket);
            System.out.println("Client connected from: " + socket.getLocalAddress().getHostName());
            AddUserName(socket);
            My_Chat_Server_Return chat = new My_Chat_Server_Return(socket);
            Thread X = new Thread(chat);
            X.start();
        }
    }
    catch (Exception X) { System.out.println(X); }
}
    public static void AddUserName(Socket X) throws IOException {
        Scanner input = new Scanner(X.getInputStream());
        String userName = input.nextLine();
        currentUsers.add(userName);

        for (int i = 1; i <= My_Chat_Server.connectionArray.size(); i++) {
            Socket temp_Socket = (Socket) My_Chat_Server.connectionArray.get(i-1);
            PrintWriter out = new PrintWriter(temp_Socket.getOutputStream());
            out.println("#?!" + currentUsers);
            out.flush();
        }
    }
}
