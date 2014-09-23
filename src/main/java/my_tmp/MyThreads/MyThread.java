package my_tmp.MyThreads;

/**
 * Created by Admin on 21.09.14.
 */
public class MyThread extends Thread {


    @Override
    public void run() {
        Thread current = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            System.out.println("id = " + current.getId() + ", name: " + current.getName() + " " + i);
        }
    }
}
