package my_tmp.MyThreads.TellAllAboutPC;

/**
 * Created by Admin on 29.09.14.
 */
class Thread3 implements Runnable {
    String str;
    Thread go;

    Thread3(String str){
        this.str = str;
        go = new Thread(this);
        go.start();
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        while (go == t){
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {}
            System.out.print(str);
        }
        System.out.println("Loop END");
    }
    public void stop(){
        go = null;
    }


    public static void main(String[] args) {
        Thread3 t1 = new Thread3("one");
        Thread3 t2 = new Thread3("two");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stop();
        t2.stop();
    }
}
