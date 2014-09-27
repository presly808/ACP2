package ua.artcode.week3.week3.HM;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 1 on 10.09.14.
 */
public class Sorter implements ActionX{
    private String path;
    private MyScanner scanner;
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public Sorter(MyScanner scanner) {
        this.scanner = scanner;
    }
    public Sorter(String path) {
        this.path = path;
        this.scanner = new MyScanner(path);
    }

    private void obtainValues(){
        int v = 0;
        while ((v = scanner.nextInt()) != -1){
            System.out.println(v);
            list.add(v);
        }
    }
    private void saveValues(){
        try {
            PrintWriter writer =new PrintWriter(path);
            for(Integer i : list){
                writer.print(i.intValue());
                writer.print(" , ");
            }
            writer.close();
            try {
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void sortValues(){
        obtainValues();
        Collections.sort(list);
        saveValues();
    }

    @Override
    public void perform() {
        sortValues();
    }
}
