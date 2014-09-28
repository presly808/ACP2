package ua.artcode.week4.day2.bank;

public class TestBankAccount {

    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(0);
        BankUserThread bankUserThread = new BankUserThread(bankAccount);
        Thread t1 = new Thread(bankUserThread);
        t1.start();
        Thread t2 = new Thread(bankUserThread);
        t2.start();


        t1.join();
        t2.join();
        System.out.println(bankAccount.getAmount());

    }
}
