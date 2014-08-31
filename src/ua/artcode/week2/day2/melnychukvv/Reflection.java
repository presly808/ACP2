package ua.artcode.week2.day2.melnychukvv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by bm13 on 31.08.2014.
 */
public class Reflection {
    private static Employee emp = new Employee("Vitaliy",666, 27);

    private static Class cl = emp.getClass();
    private static String clName = cl.getName();
    private static Method clMethods[] = cl.getDeclaredMethods();

    public static void main(String[] args) {
        for (Method i : clMethods) {
            System.out.println("Method name = " + i.getName());
            try {
                i.invoke(cl,new Object());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

class Employee {
    String name;
    double salary;
    int age;

    Employee(String name, double salary, int age){
        this.name = name;
        this.salary = salary;
        this.age = age;
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
