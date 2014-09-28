package ua.artcode.week4.day2.threads;

public class MyThread extends Thread {

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("id = " + Thread.currentThread().getId() + " name = " + Thread.currentThread().getName() + i);
        }
    }

}
