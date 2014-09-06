package ua.artcode.week3.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Vishn9 on 06.09.2014.
 */
public class ScannerAdapterEx {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("serial.txt"));

    }
}
