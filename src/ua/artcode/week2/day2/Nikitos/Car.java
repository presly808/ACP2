package ua.artcode.week2.day2.Nikitos;

import java.io.Serializable;

/**
 * Created by 1 on 04.09.14.
 */
public class Car implements Serializable{
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void titi(){
        System.out.println("!!!___!!! - ABC-D-EFG");
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}
