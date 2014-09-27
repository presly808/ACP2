package ua.artcode.week4.day2.bank;

/**
 * Created by admin on 28.06.2014.
 */
public class TestSync {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount1 = new BankAccount();

        for (int i = 0; i < 5; i++) {
            Thread thread1 = new Thread(new ClientRunnableImpl(bankAccount1));
            Thread thread2 = new Thread(new SponsorRunnableImpl(bankAccount1));
            thread1.start();
            thread2.start();
        }

        System.out.println(bankAccount1);
    }
}
