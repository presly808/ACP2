package ua.artcode.week3.day1;

import ua.artcode.week2.day2.reflection.Employee;

import java.io.*;

/**
 * Created by admin on 06.09.2014.
 */
public class SerailObjectTest {

    public static void main(String[] args) throws IOException {
        Employee empl = new Employee("Valeriy", 26, 2000);
        FileOutputStream fos = new FileOutputStream("serail.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(empl);
        oos.close();
        fos.close();




    }


}
