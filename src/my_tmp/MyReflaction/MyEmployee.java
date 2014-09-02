package my_tmp.MyReflaction;

/**
 * Created by Admin on 31.08.14.
 */
public class MyEmployee {

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

    @Override
    public String toString() {
        String str = "name: " + name + " salary: " + salary + " age: " + age;
        return str;
    }
}
