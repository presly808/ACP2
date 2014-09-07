package my_tmp.MyReflection;

import java.io.*;
import java.lang.reflect.*;
import java.util.Scanner;

/**
 * Created by Admin on 06.09.14.
 */
public class MyOutReflectionFields {
    public static void main(String[] args) throws IOException {
        MyEmployee em = new MyEmployee("Jack", 3000, 30);
        Writer wr = new BufferedWriter(new FileWriter("D://Java//ACP2//src//my_tmp//MyReflection//Fields.txt"));
        Class eClass = em.getClass();
        Field[] fields = getFields(em);
        for(Field f : fields) wr.write(f.getName() + ", is accessible: " + f.isAccessible() + "\n");
        wr.close();
    }
    public static Field[] getFields(Object obj){
        Class eClass = obj.getClass();
        Field[] fields = eClass.getDeclaredFields();

        return fields;
    }
}
