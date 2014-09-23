package my_tmp.MyAnnotation;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by Admin on 07.09.14.
 */
public class MyBigPartWriter {
    Field f;
    String path;
    public MyBigPartWriter(){
    }
    public MyBigPartWriter(Field f, String path){
        this.f = f;
        this.path = path;
    }

    public void objWriter() throws FileNotFoundException, IOException {
        Writer wr = new FileWriter(path);
        wr.write(f.getName());
        wr.flush();
        wr.close();
        System.out.println("Field wrote to file successfully");
        System.out.println("File: " + path);
    }

}
