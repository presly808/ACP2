package ua.artcode.week1.day2.collec;

//import java.util.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 24.08.2014.
 */
public class TestList {

    public static void main(String[] args) {
        List<String> team = Arrays.asList("Mikola", "Anton", "Jack", "Bogdan", "Vania");

        Collections.sort(team);

        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i));
        }
        // List < ---  ArrayList, LinkedList

        // A a = new B;
        // A a1 = a;
        // B b1 = (B) a1; - > casting reference from parent to child
        List al = new LinkedList(Arrays.asList(12, 3, 54, 56, 23, 12, 45, 65, 23));//ArrayList();
        checkList(al);
        System.out.println(al.toString());

    }

    public static void checkList(List list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if(i % 3 == 0){
                list.remove(i);
            }
        }
    }
}
