package ua.artcode.week2.day2.reflection;

/**
 * Created by admin on 31.08.2014.
 */
public class Employee {

    private String name;
    private double salary;
    private int age;

    public Employee() {
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
}
