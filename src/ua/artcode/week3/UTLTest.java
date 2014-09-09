package ua.artcode.week3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 07.09.2014.
 */
public class UTLTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.artcode.com.ua");
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                url.openStream())));
        while(br.ready()){
            System.out.println(br.readLine());
        }
    }
}
