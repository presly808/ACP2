package ua.artcode.week3.week3.HM.Chat;

import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import static java.awt.Font.BOLD;

/**
 * Created by 1 on 10.09.14.
 */
public class Client {
    private JFrame jFrame;
    private JPanel jPanel;
    private JPanel jPanelDown;
    private JTextArea textArea;
    private JButton button;
    private JLabel jLabel;
    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket;
    private JTextField jTextField;


    public Client() {
        Color lightGrey = new Color(228, 228, 228);
        Color lightBlue = new Color(102, 102, 255);
        Color dark = new Color(66, 66, 66);
        Color black = new Color(20, 20, 50);
        Color coral = new Color(3, 20, 148);
        ////////////////////////////////////////
        jFrame = new JFrame("Simple Chat");
        jPanel = new JPanel();

        //jFrame.getContentPane().add(jPanel);
        jFrame.setResizable(false);

        textArea = new JTextArea();
        textArea.setBackground(lightGrey);
        textArea.setBorder(new EmptyBorder(15, 15, 15, 15));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(textArea);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        button = new JButton("Send");
        button.addActionListener(new MyListner());
        button.setForeground(lightBlue);
        button.setMargin(new Insets(6, 60, 6, 60));
        jLabel = new JLabel("Your current Chat");
        jLabel.setBackground(lightBlue);
        jLabel.setForeground(coral);

        jTextField = new JTextField(10);
        jTextField.setPreferredSize(new Dimension(300, 40));

        jTextField.setSize(400, 20);


        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
        jPanel.add(jLabel);
        jPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        jPanel.add(textArea);
        jPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        jPanel.add(jTextField);
        jPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        jPanel.add(button);

        jFrame.getContentPane().add(jPanel);

        jFrame.setSize(400, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);


        iniciateChat();
        Thread thread = new Thread(new ListenThread());
        thread.start();
        System.out.println("New listner thread started!");
        System.out.println("Chat iniciated!");
    }

    private void iniciateChat() {
        try {
            socket = new Socket("127.0.0.1", 9991);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
//                ListenThread run = new ListenThread();
//                Thread thread = new Thread(run);
//                thread.start();
//                System.out.println("New listner thread started!");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class ListenThread implements Runnable {

        @Override
        public void run() {
            String s = "";
            try {
                System.out.println("Run method");
                //while(true){
                while ((s = reader.readLine()) != null) {
                    textArea.append("Friend: " + s + "\n");
                }
                //}
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    private class MyListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = jTextField.getText();
            writer.println(s);
            writer.flush();
            jTextField.setText("");
            jTextField.requestFocus();
            textArea.append("Me: " + s + "\n");
        }
    }
}
