package my_tmp.MyThreads.TellAllAboutPC;

/**
 * Created by Admin on 29.09.14.
 */
class Thread2 implements Runnable{
    String str;

    Thread2(String str){
        this.str = str;
    }
    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.print(str);
        }
    }

    public static void main(String[] args) {
        new Thread(new Thread2("0")).start();
        new Thread(new Thread2("1")).start();
    }
}


