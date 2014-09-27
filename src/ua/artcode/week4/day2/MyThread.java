package ua.artcode.week4.day2;

/**
 * Created by 1 on 21.09.14.
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
