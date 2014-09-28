package ua.artcode.week4.day2.threads;

public class TestInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThreadRunnable());
        thread.start();

        thread.sleep(1500);

        thread.interrupt();
    }
}
