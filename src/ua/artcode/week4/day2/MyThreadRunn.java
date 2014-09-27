package ua.artcode.week4.day2;

/**
 * Created by 1 on 23.09.14.
 */
public class MyThreadRunn implements Runnable {
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}

