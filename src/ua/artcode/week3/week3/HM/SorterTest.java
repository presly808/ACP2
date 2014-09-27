package ua.artcode.week3.week3.HM;

/**
 * Created by 1 on 10.09.14.
 */
public class SorterTest {
    public static void main(String[] args) {
        ActionX sorter = new Sorter("/Users/1/Desktop/abc.txt");
        Timer timer = new Timer(2000,sorter);
        try {
            timer.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
