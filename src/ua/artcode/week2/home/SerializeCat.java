package ua.artcode.week2.home;

import java.io.*;

public class SerializeCat {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.setAge(5);
        cat.setFlawor(new Flawor("house-cat"));

        //Serialize
        try {
            FileOutputStream fs = new FileOutputStream("cat.out");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(cat);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Deserialize
        try {
            FileInputStream fis = new FileInputStream("cat.out");
            ObjectInputStream is = new ObjectInputStream(fis);
            Cat cat1 = (Cat) is.readObject();
            is.close();
            System.out.println(cat1.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
