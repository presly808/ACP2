package ua.artcode.week4.day2.bank;

public class BankAccount {

    private double amount;

    public BankAccount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
            return amount;
    }

    public void getPercent(){
        double percent = amount * 0.2;
        synchronized (this){
            amount += percent;      //сюда может одновременно зайти только 1 поток
        }
    }

    public synchronized void setAmount(double amount) {
        this.amount = amount;
    }

    public synchronized void putMoney(double money){
        amount += money;
    }
}
