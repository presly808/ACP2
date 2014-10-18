package ua.artcode;


import org.hibernate.annotations.SourceType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.controller.UserController;
import ua.artcode.model.Contacts.ContactBean;
import ua.artcode.model.Messages.MessageBean;
import ua.artcode.model.Messages.MessagePriority;
import ua.artcode.model.Users.UserBean;
import ua.artcode.utils.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm13 on 03.10.2014.
 */
public class GeneralRunner {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF\\application-context.xml");

        UserBean user = (UserBean)applicationContext.getBean("User");
        System.out.println(user);


/*        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LogonFrame logonFrame = new LogonFrame();
                logonFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                logonFrame.setVisible(true);
            }
        });*/


        EntityManagerSingleton.closeOpenEntities();

    }



/*        UserController userController = new UserController();
        userController.add("Sasha","password");
        userController.add("Mefodiy","12312");
        userController.add("Vladimir","213231");
        userController.edit("Sasha","P@$$w0rd");
        System.out.println(userController.getUser("Sasha"));
        System.out.println(userController.getUser("Mefodiy"));
        System.out.println(userController.getUser("Vladimir"));
        userController.delete("Mefodiy");
        System.out.println(userController.getUser("Mefodiy"));*/














/*        //Testing adding and printing contacts
        UserImpl user = userList.get("root");

        ContactsListImpl contactsList = user.getContactslist();
        int contactsToCreate=1;
        String firstName;
        String lastName;
        String email;
        Scanner in = new Scanner(System.in);

        System.out.println("You're creating " + contactsToCreate + " contacts");
        for (int i=1; i<=contactsToCreate;i++) {
            System.out.println("Please type first name for " + i + " contact");
            //firstName = in.next();
            firstName="p";
            System.out.println("Please type last name for " + i + " contact");
            //lastName = in.next();
            lastName="g";
            System.out.println("Please type e-mail name for " + i + " contact");
            //email = in.next();
            email="@";
            contactsList.create(firstName,lastName,email);
        }
        in.close();

        contactsList.print();
        */



    //todo stateless check authentication before each remote command execution
    //todo log4j
    //todo loadContacts
    //todo test cases
    //todo message exchange via network
    //todo transferObject - like a packet
    //todo server
    //todo client
    //todo logging
    //todo transferObj
    //todo tokenize login password
    //todo swing interface
}

class LogonFrame extends JFrame {


    public LogonFrame() {
        setTitle("JMail");
        Dimension size = new Dimension(300,150);
        setMinimumSize(size);

        JLabel text = new JLabel("Please Sing in: ");
        text.setBounds(100,100,100,100);
        text.setFont(new Font("Arial", Font.PLAIN, 20));
        add(text, BorderLayout.NORTH);


        final JTextField loginField = new JTextField();
        final JPasswordField passwordField = new JPasswordField();


        JPanel panel= new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.setBounds(200,200,200,200);
        panel.add(new JLabel("Login: "));
        panel.add(loginField);
        panel.add(new JLabel("Password: "));
        panel.add(passwordField);
        add(panel,BorderLayout.CENTER);

        JPanel buttonPanel= new JPanel();
        JButton signIn = new JButton("Sign In");
        JButton createAccount = new JButton("Create Account");
        buttonPanel.add(signIn);
        buttonPanel.add(createAccount);
        add(buttonPanel,BorderLayout.SOUTH);

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String password = passwordField.getText();

                boolean result = new UserController().authorize(login,password);

                System.out.println(String.format("%s : %s : %b", login,password,result));

                if (result) {
                    UserBean userBean = new UserController().getUser(login);
                    MainWindow mainWindow = new MainWindow(userBean);
                    mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    mainWindow.setVisible(true);


                }
            }
        });
    }



}

class MainWindow extends JFrame{
    MainWindow(final UserBean userBean){
        setTitle("JMail Cockpit");
        Dimension size = new Dimension(800,600);
        setMinimumSize(size);

        JPanel panel= new JPanel();
        panel.setLayout(new GridLayout(1,2));

        JPanel buttonPanel= new JPanel();
        JButton usersButton = new JButton("Users");
        JButton contactsButton = new JButton("Contacts");
        JButton messagesButton = new JButton("Messages");
        buttonPanel.add(usersButton);
        buttonPanel.add(contactsButton);
        buttonPanel.add(messagesButton);
        panel.add(buttonPanel);

        add(panel,BorderLayout.NORTH);


        messagesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fieldsCount = MessageBean.class.getDeclaredFields().length;
                System.out.printf("fieldsCount = %s",fieldsCount);

                UserController userController = new UserController();
                List<MessageBean> messages = userController.getUserMessages(userBean);
                int messagesCount = messages.size();
                System.out.printf("\n\nFound %d messages\n\n",messagesCount);
                MessageTableModel messageTableModel = new MessageTableModel(messagesCount,fieldsCount,messages);
                JTable messageTable = new JTable(messageTableModel);
                add(messageTable);

            }
        });

        contactsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fieldsCount = ContactBean.class.getDeclaredFields().length;
                System.out.printf("fieldsCount = %s",fieldsCount);

                List<ContactBean> contacts = userBean.getContactsList();
                ContactsTableModel contactsTableModel = new ContactsTableModel(contacts.size(),fieldsCount,contacts);
                JTable contactsTable = new JTable(contactsTableModel);

                //add(new JScrollPane(contactsTable),BorderLayout.SOUTH);
                add(new JPanel().add(contactsTable),BorderLayout.SOUTH);

                System.out.println("Yep");
            }
        });



        this.setVisible(true);
        this.repaint();

    }
}

class MessageTableModel extends AbstractTableModel{
    private int messagesCount;
    private int columnsCount;
    private List<MessageBean> messages;
    private ArrayList<String> columnNames = null;


    MessageTableModel(int messagesCount, int columnsCount){
        this.messagesCount = messagesCount;
        this.columnsCount = columnsCount;
    }

    public MessageTableModel(int messagesCount, int fieldsCount, List<MessageBean> messages) {
        this.messages = messages;

        Field[] fields = messages.getClass().getDeclaredFields();


        System.out.println("Found such fields:");
        for (int i = 1; i <= fields.length; i++){
            String fieldName = fields[i].getName();
            System.out.printf("\n%d : %s",i,fieldName);
            this.columnNames.add(fieldName);
        }

        System.out.println(columnNames);

        new MessageTableModel(messagesCount,fieldsCount);
    }

    @Override
    public int getRowCount() {
        return messagesCount;
    }

    @Override
    public int getColumnCount() {
        return columnsCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MessageBean messageRow = messages.get(rowIndex);
        String fieldName = getColumnName(columnIndex);

        //todo finish

        return null;
    }

    public String getColumnName(int column){
        if (column > columnNames.size()) {
            throw new Error("Wrong column index");
        }
        return columnNames.get(column);
    }

}



class ContactsTableModel extends AbstractTableModel {
    private int contactsCount;
    private int columnsCount;
    private List<ContactBean> contacts;
    private ArrayList<String> columnNames = null;


    ContactsTableModel(int contactsCount, int columnsCount) {
        this.contactsCount = contactsCount;
        this.columnsCount = columnsCount;
    }

    public ContactsTableModel(int contactsCount, int fieldsCount, List<ContactBean> contacts) {
        this.contacts = contacts;

        //todo question
/*        Field[] fields = contacts.getClass().getDeclaredFields();


        System.out.println("Found such fields:");
        for (int i = 0; i <= fields.length; i++) {
            String fieldName = fields[i].getName();
            System.out.printf("\n%d : %s", i, fieldName);
            this.columnNames.add(fieldName);
        }

        System.out.println(columnNames);*/

        new ContactsTableModel(contactsCount, fieldsCount);
    }

    @Override
    public int getRowCount() {
        return contactsCount;
    }

    @Override
    public int getColumnCount() {
        return columnsCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ContactBean contactRow = contacts.get(rowIndex);

        if (columnIndex == 0) {

        } else if (columnIndex == 0) {
            return new String("0");
        } else if (columnIndex == 1) {
            return new String("1");
        } else if (columnIndex == 2) {
            return new String("2");
        } else if (columnIndex == 3) {
            return new String("3");
        } else if (columnIndex == 4) {
            return new String("4");
        } else if (columnIndex == 5) {
            return new String("5");
        } else if (columnIndex == 6) {
            return new String("6");
        } else if (columnIndex == 7) {
            return new String("7");
        } else if (columnIndex == 8) {
            return new String("8");
        }

            //todo finish

        return null;
    }

    public String getColumnName(int column) {
        return String.format("Column %d",column);
    }
}