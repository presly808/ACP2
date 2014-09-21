package ua.artcode.week1.day2.collec;

import java.util.Comparator;

/**
 * Created by admin on 24.08.2014.
 */
public class NameWorkerComparator implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
