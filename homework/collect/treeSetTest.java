package homeWork.collect;// Created by Sergey on 02.09.2014.

import java.util.Collection;
import java.util.TreeSet;

public class treeSetTest {
    public static void main(String[] args) {
        Collection myTreeSet = new TreeSet<Integer>();
        myTreeSet.add(51);
        myTreeSet.add(8);
        myTreeSet.add(-5);
        myTreeSet.add(-51);
        System.out.println(myTreeSet.toString());
    }
}
