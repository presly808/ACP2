package ua.artcode.week2.home;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cat implements Serializable{

    private int age;
    transient private Flawor flawor = new Flawor("brbrbr");
    private static int count;

    public Cat() {
        this.age = 10;
        count++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFlawor(Flawor flawor) {
        this.flawor = flawor;
    }

    public Flawor getFlawor() {
        return flawor;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", flawor=" + flawor +
                '}';
    }

    private void writeObject(ObjectOutputStream os){

        try {
            os.defaultWriteObject();
            os.writeObject(flawor.getName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream is){

        try {
            is.defaultReadObject();
            flawor = new Flawor( (String) is.readObject());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
