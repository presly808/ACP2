package my_tmp.MyBank;

import java.util.Date;

/**
 * Created by Admin on 21.09.14.
 */
public class BankUserThread implements Runnable{
    private BankAccount account;

    public BankUserThread(BankAccount account){
        this.account = account;

    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            account.putMoney(1);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(account.getAmount() + " " + Thread.currentThread().getName().toString() + " " + (new Date().getTime()-1411310000000l));
        }
    }
}
