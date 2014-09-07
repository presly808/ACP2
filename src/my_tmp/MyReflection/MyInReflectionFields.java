package my_tmp.MyReflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * Created by Admin on 06.09.14.
 * Класс считывает файл Fields.txt
 */
public class MyInReflectionFields {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(new FileInputStream("D://Java//ACP2//src//my_tmp//MyReflection//Fields.txt"));
        String str = "";
        while (sc.hasNext()){
            str += sc.nextLine() + "\n";
        }
        sc.close();
        System.out.println(str);
    }
}
