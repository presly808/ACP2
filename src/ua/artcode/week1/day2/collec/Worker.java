package ua.artcode.week1.day2.collec;

import java.util.Date;

/**
 * Created by admin on 24.08.2014.
 */
//Alt + Enter = Quick fix
public class Worker implements Comparable<Worker> {

    private int id; // Integer can has null
    private String name = "";
    private Date start = new Date();
    private int age;

    public Worker(int id, String name, Date start, int age) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.age = age;
    }

    public Worker() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + id;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        hash = 31 * hash + (start != null ? start.hashCode() : 0);
        hash = 31 * hash + age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        //instanceof and getClass
        if(obj.getClass() != Worker.class){
            return false;
        }

        Worker other = (Worker) obj;

        return this.id == other.getId() && this.age == other.getAge() &&
                this.name.equals(other.name) && this.start.equals(other.getStart());

    }

    @Override
    public int compareTo(Worker another) {
        return this.age - another.age;
    }
}
