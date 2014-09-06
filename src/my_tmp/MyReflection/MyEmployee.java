package my_tmp.MyReflection;

import java.io.Serializable;

/**
 * Created by Admin on 31.08.14.
 */
public class MyEmployee implements Serializable{

    private String name;
    private double salary;
    private int age;

    public MyEmployee() {
    }

    public MyEmployee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    private String getName(){
        return this.name;
    }

    public void sayHello(){
        System.out.println("Hello: " + toString());
    }

    @Override
    public String toString() {
        return "Employee{name:" + name + " salary:" + salary + " age:" + age + "}";
    }

}
