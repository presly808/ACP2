package homeWork.serialization;// Created by Sergey on 04.09.2014.

import java.io.*;

class Employe implements Serializable{
    private String name;
    private float salary;
    private int age;

    Employe(String name, float salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
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

public class SerializationTest {
    public static void main(String[] args) throws Exception {
        Employe employee =  new Employe("Andriy", 2000,25);

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("C:\\codeBase\\gitHub\\src\\homeWork\\demo.ser"));
        o.writeObject(employee);
        o.flush();
        o.close();

        ObjectInputStream i = new ObjectInputStream(new FileInputStream("C:\\codeBase\\gitHub\\src\\homeWork\\demo.ser"));
        Employe employe = (Employe) i.readObject();
        i.close();

        System.out.println(employe.getName());
        System.out.println(employe.getSalary());
        System.out.println(employe.getAge());
    }
}