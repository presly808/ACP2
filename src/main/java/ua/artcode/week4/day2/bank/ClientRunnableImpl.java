package ua.artcode.week4.day2.bank;

/**
 * Created by admin on 28.06.2014.
 */
public class ClientRunnableImpl implements Runnable {

    private BankAccount account;

    public ClientRunnableImpl(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        while(true){
            try {
                account.withdraw(1000);
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
