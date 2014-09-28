package ua.artcode.week5.day1.build;

/**
 * Created by admin on 27.09.2014.
 */
public class Bike {

    private final String model;
    private final int speed;
    private final int weight;
    private final double volume;

    public Bike(String model, int speed, int weight, double volume) {
        this.model = model;
        this.speed = speed;
        this.weight = weight;
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}
