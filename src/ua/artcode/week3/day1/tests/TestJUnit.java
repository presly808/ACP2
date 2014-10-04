package ua.artcode.week3.day1.tests;

import org.junit.runner.JUnitCore;

public class TestJUnit {

    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.run(TestArrayList.class);
    }
}
