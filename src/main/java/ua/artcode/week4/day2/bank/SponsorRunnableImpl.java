package ua.artcode.week4.day2.bank;

/**
 * Created by admin on 28.06.2014.
 */
public class SponsorRunnableImpl implements Runnable {

    private BankAccount bankAccount;

    public SponsorRunnableImpl(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    @Override
    public void run() {
        while(true){
            try {
                bankAccount.put(1000);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
