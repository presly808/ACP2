package ua.artcode.week3.week3.HM;

import java.io.*;

/**
 * Created by 1 on 08.09.14.
 */
public class IOtest {
    public static void main(String[] args) {
        try {
            InputStream stream = new FileInputStream("/Users/1/Desktop/abc.txt");
            MyScanner sc = new MyScanner(stream);






        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
