package my_tmp.MyThreads.TellAllAboutPC;

/**
 * Created by Admin on 29.09.14.
 */
class Thread1 extends Thread {
    String str;

    Thread1(String str){
        this.str = str;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.print(str);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestThread {
    public static void main(String[] args) {
        new Thread1("1").start();
        new Thread1("0").start();

    }
}
