package ua.artcode.week3.week3.HM;

/**
 * Created by 1 on 10.09.14.
 */
public class ActionTest {
    public static void main(String[] args) throws InterruptedException {
        ActionMan man = new ActionMan();
        Timer timer = new Timer(2000,man);
        timer.start();
    }

}
