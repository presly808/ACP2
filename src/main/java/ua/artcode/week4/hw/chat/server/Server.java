package ua.artcode.week4.hw.chat.server;

import ua.artcode.week4.hw.chat.ChatHistory;
import ua.artcode.week4.hw.chat.ClientThread;
import ua.artcode.week4.hw.chat.UserList;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

    private static UserList list = new UserList();
    private static ChatHistory chatHistory = new ChatHistory();

    public static void main(String[] args) {
        try{
            ServerSocket socketListener = new ServerSocket(Config.PORT);
            while (true){
                Socket client = null;
                while (client == null){
                    client = socketListener.accept();
                }
                new ClientThread(client);
            }
        } catch (SocketException e) {
            System.out.println("Socket exception");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("I/O Exception");
            e.printStackTrace();
        }
    }

    public synchronized static UserList getUserList(){
        return list;
    }

    public synchronized static ChatHistory getChatHistory(){
        return chatHistory;
    }
}
