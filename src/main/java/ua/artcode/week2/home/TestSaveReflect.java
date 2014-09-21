package ua.artcode.week2.home;

import ua.artcode.week2.day2.reflection.Employee;

import java.io.FileNotFoundException;

/**
 * Created by admin on 06.09.2014.
 */
public class TestSaveReflect {

    public static final String PATH = "empl.txt";

    public static void main(String[] args) throws FileNotFoundException {
        ReflectSaver rf = new ReflectSaver();
        rf.save(new Employee("valeriy", 2000, 22), PATH);
        Object loaded = rf.load(PATH);
        System.out.println(loaded);
    }
}

