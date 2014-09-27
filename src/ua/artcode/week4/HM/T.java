package ua.artcode.week4.HM;

/**
 * Created by 1 on 23.09.14.
 */
public class T {
    public static void main(String[] args) throws InterruptedException {
        Acc acc = new Acc(0);
        IThr iThr = new IThr(acc);
        iThr.start();
        System.out.println(acc.getMoney());


        for (int i = 0; i <100; i++) {
            acc.plus(10);
            System.out.println(Thread.currentThread().getName()+" | "+acc.getMoney());
           // Thread.currentThread().join();
        }
        System.out.println(acc.getMoney());


    }
}
