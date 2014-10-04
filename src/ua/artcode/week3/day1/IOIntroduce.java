package ua.artcode.week3.day1;

import java.io.*;

public class IOIntroduce {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("obj.txt");
        /*int readed = -1;
        while ((readed = is.read()) != -1){
            char c = (char) readed;
            System.out.print(c);
        }*/

        byte[] buff = new byte[100];
        int readedSize = is.read(buff);
        System.out.print(new String(buff, 0, readedSize));

        OutputStream os = new FileOutputStream("newobj.ttt");
        os.write(buff);
        os.flush();
        os.close();
    }
}
