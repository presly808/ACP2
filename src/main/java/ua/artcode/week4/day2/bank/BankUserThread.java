package ua.artcode.week4.day2.bank;

public class BankUserThread implements Runnable {

    private BankAccount account;

    public BankUserThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++){
            account.putMoney(1);
//            System.out.println(account.getAmount());
        }

    }
}
