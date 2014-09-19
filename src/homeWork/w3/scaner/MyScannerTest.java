package homeWork.w3.scaner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MyScanner {
    int iter;
    String str;
    char[] chars;
    public MyScanner(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = br.readLine();
            chars = str.toCharArray();
            iter = 0;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean hasNext(){
        return (iter + 1) < chars.length;
    }
    public boolean hasNextInt(){
        return hasNext() && isDigit(chars[iter + 1]);
    }

    public boolean isDigit(char ch){
        return ch >= 48 && ch <= 57;
    }
    public boolean isLetter(char ch){
        return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
    }

    public String next(){
        String s = "";
        while (iter < chars.length) {
            if (isLetter(chars[iter])) {
                s += chars[iter];
                iter++;
            } else break;
        }
        return s;
    }

    public int nextInt(){
        String s = "";
        if (chars[iter] == '-' && hasNextInt()){
            s += chars[iter];
            iter++;
        }
        while (iter < chars.length) {
            if (isDigit(chars[iter])) {
                s += chars[iter];
                iter++;
            } else break;
        }
        return Integer.parseInt(s);
    }

    public String nextLine(){
        return str;
    }

    public void useDelemiter(String str){

    }

    public void close(){
        iter = 0;
        str = "";
    }

    public void showAll(){
        System.out.println("String = " + str);
    }
}
public class MyScannerTest {
    public static void main(String[] args) {

        MyScanner scanner = new MyScanner();
        System.out.println(scanner.nextInt());
        //System.out.println(scanner.next());
    }
}