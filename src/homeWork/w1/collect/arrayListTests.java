package homeWork.w1.collect;// Created by Sergey on 01.09.2014.

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class arrayListTests {
    public static void main(String[] args) {
        String[] simpleArray = {"Ivan","Petro","Vasyl"};

        Collection myArrLst= new ArrayList<String>();

        Collections.addAll(myArrLst, simpleArray);

        for (Object s:myArrLst){
            System.out.println(s);
        }
        myArrLst.remove("Ivan");
        for (Object s:myArrLst){
            System.out.println(s);
        }
    }
}