package ua.artcode.week1.day2.collec;

import java.util.*;

/**
 * Created by admin on 24.08.2014.
 */
public class TestSet {

    public static void main(String[] args) {
        int hashDate = new Date().hashCode();
        // TreeSet use Comparator or Comparable
        Set<Integer> set = new TreeSet<Integer>();

        set.add(Integer.valueOf(56));  // Autoboxing
        set.add(11);
        set.add(89);
        set.add(9);
        set.add(3);

        // for each construction
        for(Integer o : set){
            System.out.println(o);
        }

        System.out.println("Interator in action");
        Iterator iter = set.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }


        Worker worker1 = new Worker(1, "Kolia", new Date(), 23);
        Worker worker2 = new Worker(2, "Victor", new Date(), 22);
        Worker worker3 = new Worker(3, "Andrey", new Date(), 30);

        Comparator<Worker> nameComparator = new NameWorkerComparator();


        Set<Worker> workers = new TreeSet<Worker>(nameComparator);
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);

        for(Worker w : workers){
            System.out.println(w);
        }


        System.out.println(hashDate + " " + new Date().hashCode());

    }

}
