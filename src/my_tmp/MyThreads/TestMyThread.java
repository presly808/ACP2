package my_tmp.MyThreads;

/**
 * Created by Admin on 21.09.14.
 */
public class TestMyThread {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new MyThreadRun()).start();
        System.out.println("Sleeping 2sec");
        Thread.sleep(2000);

        MyThread myThread = new MyThread();

        myThread.start();
        myThread.join();


    }
}
