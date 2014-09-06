package ua.artcode.week3.day1;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by Vishn9 on 06.09.2014.
 */
public class ModernEmployee extends InputStream implements Serializable, ModernWorker {
    private String name;
    private double bigSalary;
    private int age;

    public ModernEmployee() {
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    public double getBigSalary() {
        return bigSalary;
    }

    public ModernEmployee(String name, double bigSalary, int age) {
        this.name = name;
        this.bigSalary = bigSalary;
        this.age = age;
    }

    public void sayHello(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "ModernEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + bigSalary +
                ", age=" + age +
                '}';
    }
}
