package homeWork;// Created by Sergey on 31.08.2014.

public class Employee {
    private String name;
    private float salary;
    private int age;

    public Employee(String name, float salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
    private void tellMe(){
        System.out.println("told");
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}
