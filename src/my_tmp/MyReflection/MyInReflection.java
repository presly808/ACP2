package my_tmp.MyReflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Admin on 06.09.14.
 */
public class MyInReflection {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("decor.file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        MyEmployee em = (MyEmployee)ois.readObject();
        ois.close();
        fis.close();

        em.sayHello();
    }
}
