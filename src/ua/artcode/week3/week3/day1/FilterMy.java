package ua.artcode.week3.week3.day1;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 1 on 06.09.14.
 */
public class FilterMy implements Fifi{
    InputStream stream;
    String str = "";

    public FilterMy(InputStream stream) {
        this.stream = stream;
    }

    public InputStream getStream() {

        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public String filter() throws IOException {
        String s = "";
//        while ((s = stream.) != -1){
//            str += s;
//        }
        str.replace("A","a");
        s = str;
        return s;
    }
}
