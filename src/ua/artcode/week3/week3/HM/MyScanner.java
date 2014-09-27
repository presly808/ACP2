package ua.artcode.week3.week3.HM;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 1 on 09.09.14.
 */
public class MyScanner implements Closeable{
    private InputStream inputStream;
    private String path;
    private ArrayList<Integer> symbols = new ArrayList<Integer>();
    //private Readable source;

    public MyScanner(String path) {
        try {
            this.inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyScanner(InputStream inputStream) {
        this.inputStream = inputStream;

    }

    public int nextInt() {
        int s = 0;
        try {
            while (((s=inputStream.read()) > 46) && (s < 59)){
                symbols.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String temp = "";
        for(int i = 0; i<symbols.size();i++){
            temp +=(char)symbols.get(i).intValue();
        }
        if(s ==-1){
            return -1;
        }
        s = Integer.parseInt(temp);
        symbols.clear();

        return s;
    }

    public String nextLine(){
        String s = "";
        StringBuilder sb = new StringBuilder();
        int ss = 0;
        try {
            while (((ss = inputStream.read()) != 10) &&  ss != -1){
               symbols.add(ss);
                System.out.println(ss);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i<symbols.size();i++){
            sb.append((char)symbols.get(i).intValue());
        }
        s = sb.toString();
        symbols.clear();
        return s;
    }
    public String next(){
        String s = "";
        StringBuilder sb = new StringBuilder();
        int ss = 0;
        try {
            while (((ss=inputStream.read()) != 32) && (ss != -1)){
                symbols.add(ss);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0; i<symbols.size();i++){
        sb.append((char)symbols.get(i).intValue());
        }
        s = sb.toString();
        symbols.clear();
        return s;

    }
    public boolean hasNextInt(){

        inputStream.mark(1);

        int c = 0;
        try {
            if(((c = inputStream.read()) > 47) &&(c < 59)){
                inputStream.reset();
               return true;
            }else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }


    public boolean hasNext() {
        try {
            boolean s =  (inputStream.available() > 0);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
