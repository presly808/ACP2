package ua.artcode.week1.day2.collec;

import java.util.Date;

/**
 * Created by Admin on 29.08.14.
 */
public class TestMyHashTable {
    public static void main(String[] args) {
        MyHashtable<Worker> table = new MyHashtable<Worker>();
        System.out.println("add: " + table.add(new Worker(1, "Jack", new Date(), 30)));
        Worker wr2 = new Worker(5, "Avy", new Date(), 23);
        table.add(wr2);
        System.out.println("isEmpty(): " + table.isEmpty());
        System.out.println("size: " + table.size());
        Object[] array = new Worker[table.size()];
                array = table.toArray();
        System.out.println("new array.length: " + array.length);
        for (Object x : array){
            if (x != null) System.out.println(x.toString());
        }
        System.out.println("contains " + wr2.getName() + ": " + table.contains(wr2));
        table.toString();
        System.out.println("remove " + wr2.getName() + ": " + table.remove(wr2));
        table.toString();
        table.clear();
        System.out.println("size: " + table.size());

    }
}
