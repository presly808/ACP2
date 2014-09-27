package ua.artcode.week4.day2.threads;

/**
 * Created by admin on 21.09.2014.
 */
public class TestMyThread {

    public static void main(String[] args) throws InterruptedException {


        new Thread(new MyThreadRunn()).start();

        MyThread myThread = new MyThread(Thread.currentThread());
        myThread.start();

        Thread.sleep(100);
        System.out.println("After sleep");
        System.out.println(myThread.getState().name());

        MyThread myThread2 = new MyThread(Thread.currentThread());
        myThread2.start();

        myThread2.join();
        System.out.println("after join");





    }
}
