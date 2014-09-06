package ua.artcode.week3.day1;

import ua.artcode.week2.day2.reflection.Employee;

import java.io.*;

/**
 * Created by Vishn9 on 06.09.2014.
 */
public class SerialObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee empl = new Employee("Valerka", 2000, 26);
        FileOutputStream fos = new FileOutputStream("serial.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(empl);
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("serial.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee empl2 = (Employee) ois.readObject();
        System.out.println(empl2);
    }
}
