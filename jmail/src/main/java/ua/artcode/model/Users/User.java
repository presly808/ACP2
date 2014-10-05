package ua.artcode.model.Users;

import ua.artcode.controller.MessageImpl;
import ua.artcode.model.Messages.MessageInterface;
import ua.artcode.model.Request.ActionList;
import ua.artcode.model.Request.RequestObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 1 on 04.10.14.
 */
public class User {
    private String login;
    private String password;
    private int id;
    private MessageInterface messageInterface;
    private List<MessageInterface> listOfMessages;
    private HashMap<String ,User> contactList;
    private Socket socket;
    private ObjectOutputStream outputStream;
    private RequestObject request;

    private void createMessage(String subject,String body,UserInterface to){
        MessageInterface message = new MessageImpl(this,to,subject,body);

    }
    public void sendMessage(Integer messageId){

        try {
            MessageInterface toSend = listOfMessages.get(messageId);
            request = new RequestObject(ActionList.SEND_MESSAGE,login,password,toSend);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private class MessageListner implements Runnable{
        ObjectInputStream inputStream = null;

        @Override
        public void run() {
            try {
                inputStream = new ObjectInputStream(socket.getInputStream());
                Object obj = null;
                while ((obj = inputStream.readObject()) != null){
                    MessageInterface msg = (MessageImpl)obj;

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

}
