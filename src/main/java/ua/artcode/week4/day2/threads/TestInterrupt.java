package ua.artcode.week4.day2.threads;

/**
 * Created by admin on 21.09.2014.
 */
public class TestInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThreadRunn());
        thread.start();

        Thread.sleep(1500);

        thread.interrupt();
    }
}
