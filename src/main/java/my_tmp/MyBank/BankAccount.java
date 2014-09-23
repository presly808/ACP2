package my_tmp.MyBank;

/**
 * Created by Admin on 21.09.14.
 */
public class BankAccount {

    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        synchronized(this){

        }
        return amount;
    }

    public void getPercent(){
        double percent = amount * 0.2;
        synchronized (this){
            amount += percent;
        }
    }

    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }
    public synchronized void putMoney(double money){
        amount += money;
    }
}
