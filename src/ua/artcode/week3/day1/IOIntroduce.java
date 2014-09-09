package ua.artcode.week3.day1;

import java.io.*;

/**
 * Created by admin on 06.09.2014.
 */
public class IOIntroduce {

    public static final String EMPL_TXT = "empl.txt";

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(EMPL_TXT);
        /*int readed = -1;
        while((readed = is.read()) != -1){
            char c = (char) readed;
            System.out.print(c);
        }*/

        byte[] buff = new byte[100];
        int readedSize = is.read(buff);
        System.out.print(new String(buff, 0, readedSize));

        OutputStream os = new FileOutputStream(EMPL_TXT);
        os.write("new text for text".getBytes());
        os.flush();
        os.close();
    }
}
