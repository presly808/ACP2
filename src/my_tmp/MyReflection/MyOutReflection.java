package my_tmp.MyReflection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Admin on 06.09.14.
 */
public class MyOutReflection {
    public static void main(String[] args) throws IOException {
        MyEmployee em = new MyEmployee("Jack", 3000, 30);
        FileOutputStream fos = new FileOutputStream("decor.file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(em);
        oos.close();
        fos.close();
    }
}
