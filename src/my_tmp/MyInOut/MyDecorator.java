package my_tmp.MyInOut;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Admin on 06.09.14.
 */
public class MyDecorator {
    public static void main(String[] args) throws FileNotFoundException {
        String string = "123 Tro-lo-lo A ZikkurAt AFK";
        MyStringFilter01 sf = new MyStringFilter01();
        FileOutputStream fos = new FileOutputStream("decor.file");
        BufferedOutputStream bos = new BufferedOutputStream(fos);


        show(string);
    }

    public static void show(String str){
        System.out.println(str);

    }

}
