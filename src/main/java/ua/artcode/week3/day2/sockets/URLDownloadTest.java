package ua.artcode.week3.day2.sockets;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by admin on 07.09.2014.
 */
public class URLDownloadTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input URL of file");
        String url = sc.nextLine();
        System.out.println("Input file path with extension");
        String filepath = sc.nextLine();

        try {
            save(new URL(url), filepath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void save(URL imageUrl, String filepath){
        try (InputStream is = imageUrl.openStream();
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileOutputStream fos = new FileOutputStream(filepath)){

            byte[] buff = new byte[1000000];
            int readed = 0;
            while ((readed = is.read(buff)) != -1){
                baos.write(buff, 0, readed);
            }

            fos.write(baos.toByteArray());
            fos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
