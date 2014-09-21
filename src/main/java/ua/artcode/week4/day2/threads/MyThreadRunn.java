package ua.artcode.week4.day2.threads;

/**
 * Created by admin on 21.09.2014.
 */
public class MyThreadRunn implements Runnable {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
