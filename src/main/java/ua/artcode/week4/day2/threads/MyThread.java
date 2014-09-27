package ua.artcode.week4.day2.threads;

/**
 * Created by admin on 21.09.2014.
 */
public class MyThread extends Thread {

    Thread main;

    public MyThread(Thread main) {
        this.main = main;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            System.out.println(
                    "id = " + current.getId() + " name = "
                            +current.getName() + " " + i);
        }
    }
}
