package ua.artcode.week1.day2.collec;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 24.08.2014.
 */
public class HashTest {

    public static void main(String[] args) {

        Set<Worker> hashSet = new HashSet<>();

        Worker worker1 = new Worker(1, "Kolia", new Date(), 23);
        Worker worker2 = new Worker(2, "Victor", new Date(), 22);
        Worker worker3 = new Worker(3, "Andrey", new Date(), 30);

        hashSet.add(worker1);
        hashSet.add(worker2);
        hashSet.add(worker3);

        Worker worker4 = new Worker(1, "Kolia", new Date(), 23);

        System.out.println(hashSet.contains(worker4));



    }
}
