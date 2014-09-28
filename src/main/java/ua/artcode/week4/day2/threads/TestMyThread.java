package ua.artcode.week4.day2.threads;

public class TestMyThread {

    public static void main(String[] args) throws InterruptedException {


        MyThreadRunnable threadRunnable = new MyThreadRunnable();
        new Thread(threadRunnable).start();

        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.start();
        //Thread.sleep(2000);
        myThread.join();
        System.out.println(myThread.getState());



    }
}
