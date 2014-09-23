package ua.artcode.week1.day2.excep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by admin on 24.08.2014.
 */
// Checked adn Unchecked
public class Test {

    public static void main(String[] args) throws Exception {

        System.out.println("Before");
        test();
        System.out.println("After");

    }

    private static void test() throws Exception {
        Scanner sc = new Scanner(new File("some.txt"));
    }
}
