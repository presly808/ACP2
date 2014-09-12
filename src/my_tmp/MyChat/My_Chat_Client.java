package my_tmp.MyChat;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Admin on 12.09.14.
 */
public class My_Chat_Client implements Runnable {
    // Global
    Socket socket;
    Scanner input;
    Scanner send = new Scanner(System.in);
    PrintWriter out;

    public My_Chat_Client(Socket x) {
        this.socket = x;
    }

    @Override
    public void run() {
        try {
            try {
                input = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream());
                out.flush();
                checkStream();
            } finally {
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void disconnect() throws IOException {
        out.println(My_Chat_Client_GUI.userName + " has disconnected.");
        out.flush();
        socket.close();
        JOptionPane.showMessageDialog(null, "You disconnected!");
        System.exit(0);
    }

    public void checkStream() {
        while (true) {
            receive();
        }
    }

    public void receive() {
        if (input.hasNext()) {
            String message = input.nextLine();
            if (message.contains("#?!")) {
                String  temp1 = message.substring(3);
                        temp1 = temp1.replace("[", "");
                        temp1 = temp1.replace("]", "");
                String[] currentUser = temp1.split(", ");

                My_Chat_Client_GUI.jl_Online.setListData(currentUser);
            }
            else {
                My_Chat_Client_GUI.ta_Conversation.append(message + "\n");
            }
        }
    }

    public void send (String str) {
        out.println(My_Chat_Client_GUI.userName + ": " + str);
        out.flush();
        My_Chat_Client_GUI.tf_Message.setText("");
    }
}
