package ua.artcode.week3.day1.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by admin on 06.09.2014.
 */
public class ScannerAdapterEx {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("empl.txt"));
    }
}
