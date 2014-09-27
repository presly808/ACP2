package ua.artcode.week4.day2.bank;

/**
 * Created by 1 on 21.09.14.
 */
public class UserThread implements Runnable {
    private BankAccount account;

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public UserThread(BankAccount account) {

        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
           account.putMoney(1.0);
        }

    }
}
