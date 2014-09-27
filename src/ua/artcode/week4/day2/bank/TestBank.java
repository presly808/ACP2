package ua.artcode.week4.day2.bank;

/**
 * Created by 1 on 21.09.14.
 */
public class TestBank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0);

        new Thread(new UserThread(account)).start();
        new Thread(new UserThread(account)).start();

        System.out.println(account.getAmount());
    }
}
