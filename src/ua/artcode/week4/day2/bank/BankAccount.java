package ua.artcode.week4.day2.bank;

/**
 * Created by 1 on 21.09.14.
 */
public class BankAccount {
    private double amount;

    public double getAmount() {

            return amount;

    }

    public synchronized void  setAmount(double amount) {
        this.amount = amount;
    }

    public BankAccount(double amount) {
        this.amount = amount;
    }
    public synchronized void putMoney(double money){
        amount += money;
    }
    public void getPercent(){
        double percrnt = amount * 0.2;
        synchronized (this){
            amount += percrnt;
        }

    }
}
