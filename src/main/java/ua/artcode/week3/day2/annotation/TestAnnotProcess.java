package ua.artcode.week3.day2.annotation;

import java.io.IOException;

/**
 * Created by admin on 07.09.2014.
 */
public class TestAnnotProcess {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        Container container = new Container("Some file desc", 2345);
        ProcessAnnotation.processObject(container);


    }
}
