package homeWork.DynamicSorter;// Created by Sergey on 12.09.2014.

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DSorter {
    public void sort() throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        FileWriter fout = new FileWriter("test.txt");
        fout.write("11 9 7 1");
        fout.close();
        FileReader fin = new FileReader("test.txt");
        Scanner src = new Scanner(fin);

        while (src.hasNext()) {
            if (src.hasNextInt()) {
                list.add(src.nextInt());
            }
        }
        Collections.sort(list);
        FileWriter fout1 = new FileWriter("test.txt");
        for (int i = 0; i < list.size()-1; i++) {
            fout1.write(list.get(i).toString()+ " ");
        }
        fout1.write(list.get(list.size()-1).toString());
        fout1.close();
        src.close();
    }
}