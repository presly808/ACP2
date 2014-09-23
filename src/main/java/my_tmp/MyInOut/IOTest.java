package my_tmp.MyInOut;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Admin on 06.09.14.
 */
public class IOTest {
    public static void main(String[]args) throws IOException{
        InputStream is = new FileInputStream("text.txt");

        int reader = -1;
        while ((reader = is.read()) != -1){
            char ch = (char) reader;
            System.out.print(ch);
        }
    }
}
