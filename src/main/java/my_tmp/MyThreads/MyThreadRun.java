package my_tmp.MyThreads;

/**
 * Created by Admin on 21.09.14.
 */
public class MyThreadRun implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();

        System.out.println("run method runnable");
        System.out.println("id = " + current.getId() + ", name: " + current.getName());
    }
}
