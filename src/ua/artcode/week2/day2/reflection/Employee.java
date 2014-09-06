package ua.artcode.week2.day2.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by admin on 31.08.2014.
 */
public class Employee extends InputStream implements Serializable {

    private String name;
    private double salary;
    private int age;

    public Employee() {
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public void sayHello(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public double getSalary() {
        return salary;
    }
}
