package ua.artcode.week4.HM;

/**
 * Created by 1 on 23.09.14.
 */
public class IThr extends Thread{
    Acc acc;

    public IThr(Acc acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
            acc.plus(10);
            Thread.currentThread().setName("UltraThread");
            System.out.println(Thread.currentThread().getName()+" | "+acc.getMoney());

        }
    }
}
