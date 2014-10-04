package ua.artcode.week3.day1;

import ua.artcode.week2.home.StudentNew;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationObjectTest {
    public static void main(String[] args) throws IOException {

        StudentNew studentNew = new StudentNew();

        FileOutputStream fos = new FileOutputStream("serial.ttt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(studentNew);
        fos.close();
        oos.close();
    }
}
