package my_tmp.MyChat;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class My_Chat_Server_Return implements Runnable {
    //Globals
    Socket socket;
    private Scanner input;
    private PrintWriter out;
    String message = "";

    public My_Chat_Server_Return(Socket X) {
        this.socket = X;
    }

    public void checkConnection() throws IOException {
        if (!socket.isConnected()){
            for (int i = 1; i <= My_Chat_Server.connectionArray.size(); i++) {
                if (My_Chat_Server.connectionArray.get(i) == socket){
                    My_Chat_Server.connectionArray.remove(i);
                }
            }

            for (int i = 1; i <= My_Chat_Server.connectionArray.size(); i++) {
                Socket temp_Socket = (Socket) My_Chat_Server.connectionArray.get(i-1);
                PrintWriter temp_out = new PrintWriter(temp_Socket.getOutputStream());
                temp_out.println(temp_Socket.getLocalAddress().getHostName() + "disconnected!");
                temp_out.flush();
                //Show disconnected at server
                System.out.println(temp_Socket.getLocalAddress().getHostName() + "disconnected!");
            }
        }
    }

    public void run() {
        try {
            try {
                input = new Scanner(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream());

                while (true) {
                    checkConnection();

                    if (!input.hasNext()) { return; }

                    message = input.nextLine();

                    System.out.println("Client said: " + message);
                    for (int i = 1; i <= My_Chat_Server.connectionArray.size(); i++) {
                        Socket temp_Socket = (Socket) My_Chat_Server.connectionArray.get(i-1);
                        PrintWriter temp_out = new PrintWriter(temp_Socket.getOutputStream());
                        temp_out.println(message);
                        temp_out.flush();
                        System.out.println( "Sent to: " + temp_Socket.getLocalAddress().getHostName());
                    } // close for loop
                } // close while loop
            } // close iner try
            finally {
                socket.close();
            }

        } // close outer try
        catch (Exception X){ System.out.println(X); }
    }
}
