package ua.artcode.week1.day1;

/**
 * Created by admin on 23.08.2014.
 */
public class TestRecursion {

    public static void main(String[] args) {
        IFactRecursionImpl factRecursion = new IFactRecursionImpl();
        factRecursion.rec(13);
        factRecursion.showCache();

        factRecursion.rec(7);
    }
}
