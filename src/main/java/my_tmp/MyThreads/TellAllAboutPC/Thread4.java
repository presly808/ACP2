package my_tmp.MyThreads.TellAllAboutPC;

/**
 * Created by Admin on 29.09.14.
 */
public class Thread4 implements Runnable {
    @Override
    synchronized public void run() {
        System.out.print("Hello, ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.println("JAVA!");
    }

    public static void main(String[] args) {
        Thread4 t = new Thread4();
        new Thread(t).start();
        new Thread(t).start();
    }
}
