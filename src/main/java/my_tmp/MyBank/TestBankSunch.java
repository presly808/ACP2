package my_tmp.MyBank;

/**
 * Created by Admin on 21.09.14.
 */
public class TestBankSunch {
    public static void main(String[] args) throws InterruptedException {

        BankAccount ba = new BankAccount(0);

        Thread t1 = new Thread(new BankUserThread(ba));
        Thread t2 = new Thread(new BankUserThread(ba));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(ba.getAmount());
    }
}
