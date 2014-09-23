package my_tmp.MyChat;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class My_Chat_Client_GUI {
    // Global
    public static My_Chat_Client chatClient;
    public static String userName = "Anonymous";

    // GUI Globals - Main Window
    public static JFrame mainWindow = new JFrame();
    private static JButton b_About = new JButton();
    private static JButton b_Connect = new JButton();
    private static JButton b_Disconnect = new JButton();
    private static JButton b_Help = new JButton();
    private static JButton b_Send = new JButton();
    private static JLabel l_Message = new JLabel("Message: ");
    public static JTextField tf_Message = new JTextField(15);
    private static JLabel l_Conversation = new JLabel();
    public static JTextArea ta_Conversation = new JTextArea();
    private static JScrollPane sp_Conversation = new JScrollPane();
    private static JLabel l_Online = new JLabel();
    public static JList jl_Online = new JList();
    private static JScrollPane sp_Online = new JScrollPane();
    private static JLabel l_LoggedInAs = new JLabel();
    private static JLabel l_LoggedInAsBox = new JLabel();

    // GUI Global - LogIn Window
    public static JFrame loginWindow = new JFrame();
    public static JTextField tf_UserNameBox = new JTextField(15);
    private static JButton b_Enter = new JButton("Enter");
    private static JLabel l_EnteryUserName = new JLabel("Enter username: ");
    private static JPanel p_Login = new JPanel();

    public static void main(String[] args) {
        buildMainWindow();
        initialize();
    }

    public static void connect() {
        try {
            final int port = 444;
            final String host = "localhost";
            Socket socket = new Socket(host, port);
            System.out.println("You connected to: " + host);

            chatClient = new My_Chat_Client(socket);

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(userName);
            out.flush();

            Thread X = new Thread(chatClient);
            X.start();
        }
        catch (Exception X) {
            System.out.println(X);
            JOptionPane.showMessageDialog(null, "Server not responding.");
            System.exit(0);
        }
    }

    public static void initialize() {
        b_Send.setEnabled(false);
        b_Disconnect.setEnabled(false);
        b_Connect.setEnabled(true);
    }

    public static void buildLogInWindow() {
        loginWindow.setTitle("What's your name?");
        loginWindow.setSize(400, 100);
        loginWindow.setLocation(250, 200);
        loginWindow.setResizable(false);
        p_Login = new JPanel();
        p_Login.add(l_EnteryUserName);
        p_Login.add(tf_UserNameBox);
        p_Login.add(b_Enter);
        loginWindow.add(p_Login);

        login_Action();
        loginWindow.setVisible(true);
    }

    public static void buildMainWindow() {
        mainWindow.setTitle(userName + "'s Chat Box");
        mainWindow.setSize(450, 500);
        mainWindow.setLocation(220, 180);
        mainWindow.setResizable(false);

        configureMainWindow();
        mainWindow_Action();

        mainWindow.setVisible(true);
    }

    public static void configureMainWindow() {
        mainWindow.setBackground(new Color(255, 255, 255));
        mainWindow.setSize(500, 320);
        mainWindow.getContentPane().setLayout(null);

        b_Send.setBackground(new Color(0, 0, 255));
        b_Send.setForeground(new Color(255, 255, 255));
        b_Send.setText("Send");
        mainWindow.getContentPane().add(b_Send);
        b_Send.setBounds(250, 40, 81, 25);

        b_Disconnect.setBackground(new Color(0, 0, 255));
        b_Disconnect.setForeground(new Color(255, 255, 255));
        b_Disconnect.setText("Disconnect");
        mainWindow.getContentPane().add(b_Disconnect);
        b_Disconnect.setBounds(10, 40, 110, 25);

        b_Connect.setBackground(new Color(0, 0, 255));
        b_Connect.setForeground(new Color(255, 255, 255));
        b_Connect.setText("Connect");
        b_Connect.setToolTipText("");
        mainWindow.getContentPane().add(b_Connect);
        b_Connect.setBounds(130, 40, 110, 25);

        b_Help.setBackground(new Color(0, 0, 255));
        b_Help.setForeground(new Color(255, 255, 255));
        b_Help.setText("Help");
        mainWindow.getContentPane().add(b_Help);
        b_Help.setBounds(420, 40, 70, 25);

        b_About.setBackground(new Color(0, 0, 255));
        b_About.setForeground(new Color(255, 255, 255));
        b_About.setText("About");
        mainWindow.getContentPane().add(b_About);
        b_About.setBounds(340, 40, 75, 25);

        l_Message.setText("Message");
        mainWindow.getContentPane().add(l_Message);
        l_Message.setBounds(10, 10, 60, 20);

        tf_Message.setForeground(new Color(0, 0, 255));
        tf_Message.requestFocus();
        mainWindow.getContentPane().add(tf_Message);
        tf_Message.setBounds(70, 4, 260, 30);

        l_Conversation.setHorizontalAlignment(SwingConstants.CENTER);
        l_Conversation.setText("Conversation");
        mainWindow.getContentPane().add(l_Conversation);
        l_Conversation.setBounds(100, 70, 140, 16);

        ta_Conversation.setColumns(20);
        ta_Conversation.setFont(new Font("Tahoma", 0, 12));
        ta_Conversation.setForeground(new Color(0, 0, 255));
        ta_Conversation.setLineWrap(true);
        ta_Conversation.setRows(5);
        ta_Conversation.setEditable(false);

        sp_Conversation.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp_Conversation.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp_Conversation.setViewportView(ta_Conversation);
        mainWindow.getContentPane().add(sp_Conversation);
        sp_Conversation.setBounds(10, 90, 330, 180);

        l_Online.setHorizontalAlignment(SwingConstants.CENTER);
        l_Online.setText("Currently online");
        l_Online.setToolTipText("");
        mainWindow.getContentPane().add(l_Online);
        l_Online.setBounds(350, 70, 130, 16);

        //String[] testNames = {"Bob", "Charly", "Alex"};
        jl_Online.setForeground(new Color(0, 0, 255));
        //jl_Online.setListData(testNames);

        sp_Online.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp_Online.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp_Online.setViewportView(jl_Online);
        mainWindow.getContentPane().add(sp_Online);
        sp_Online.setBounds(350, 90, 130, 180);


        l_LoggedInAs.setFont(new Font("Tahoma", 0, 12));
        l_LoggedInAs.setText("Currently Logged In As");
        mainWindow.getContentPane().add(l_LoggedInAs);
        l_LoggedInAs.setBounds(348, 0, 140, 15);

        l_LoggedInAsBox.setHorizontalAlignment(SwingConstants.CENTER);
        l_LoggedInAsBox.setFont(new Font("Tahoma", 0, 12));
        l_LoggedInAsBox.setForeground(new Color(255, 0, 0));
        l_LoggedInAsBox.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        mainWindow.getContentPane().add(l_LoggedInAsBox);
        l_LoggedInAsBox.setBounds(340, 17, 150, 20);
    }

    public static void login_Action() {
        b_Enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action_b_enter();
            }
        });
    }

    public static void action_b_enter() {
        if (!tf_UserNameBox.getText().equals("")) {
            userName = tf_UserNameBox.getText().trim();
            l_LoggedInAsBox.setText(userName);
            My_Chat_Server.currentUsers.add(userName);
            mainWindow.setTitle(userName + "'s Chat Box");
            loginWindow.setVisible(false);
            b_Send.setEnabled(true);
            b_Disconnect.setEnabled(true);
            b_Connect.setVisible(false);
            connect();
        }
        else {
            JOptionPane.showMessageDialog(null, "Please enter a name!");
        }
    }

    public static void mainWindow_Action() {
        b_Send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action_b_send();
            }
        });
        b_Disconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action_b_disconnect();
            }
        });
        b_Connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buildLogInWindow();
            }
        });
        b_Help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void action_b_send() {
        if (!tf_Message.getText().equals("")) {
            chatClient.send(tf_Message.getText());
        }
    }
    public static void action_b_disconnect() {
        try {
            chatClient.disconnect();
        }
        catch (Exception y) { System.out.println(y); }
    }

    public static void action_b_help() {

    }
}
