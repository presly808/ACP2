package ua.artcode.server;

import ua.artcode.transfer.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * pattern Observer(Listener)
 */
 public class OutStreamsContainer {

    private List<OutputStream> clientOutputStreamList;

    public OutStreamsContainer(List<OutputStream> clientOutputStreamList) {
        this.clientOutputStreamList = clientOutputStreamList;
    }

    public List<OutputStream> getClientOutputStreamList() {
        return clientOutputStreamList;
    }

    public void setClientOutputStreamList(List<OutputStream> clientOutputStreamList) {
        this.clientOutputStreamList = clientOutputStreamList;
    }

    public void addOutputStream(OutputStream outputStream){
        clientOutputStreamList.add(outputStream);
    }

    public void notifyAllClients(Message message){
        for(OutputStream outputStream : clientOutputStreamList){
            try {
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                oos.writeObject(message);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
