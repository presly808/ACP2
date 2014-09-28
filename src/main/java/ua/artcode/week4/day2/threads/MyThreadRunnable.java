package ua.artcode.week4.day2.threads;

public class MyThreadRunnable implements Runnable {



    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " Runnable interface");
        }
    }
}
