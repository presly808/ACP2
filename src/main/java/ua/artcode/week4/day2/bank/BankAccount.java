package ua.artcode.week4.day2.bank;

/**
 * Created by admin on 28.06.2014.
 */
public class BankAccount {

    private static final int LIMIT = 1000;
    private int amount;

    public synchronized void withdraw(int money) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " withdrawing " +amount);
        while (amount < LIMIT) {
            this.wait();//
        }
        amount -= money;
        System.out.println(Thread.currentThread().getName() + " withdrawed " + amount);
        this.notifyAll();
    }

    public synchronized void put(int money) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " putting money " + amount);
        while (amount > LIMIT){
            this.wait();
        }
        amount += money;
        System.out.println(Thread.currentThread().getName() + " put " + amount);
        this.notifyAll();
    }

}
