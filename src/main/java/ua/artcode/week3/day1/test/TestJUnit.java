package ua.artcode.week3.day1.test;

import org.junit.runner.JUnitCore;

/**
 * Created by admin on 06.09.2014.
 */
public class TestJUnit {

    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.run(ArrayListUnitTest.class);

    }
}
