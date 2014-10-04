package ua.artcode.week3.day1.myAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerAdapterEx {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("ddd.ddd"));
    }
}
