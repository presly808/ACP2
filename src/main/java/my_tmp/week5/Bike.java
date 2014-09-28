package my_tmp.week5;

/**
 * Created by Admin on 27.09.14.
 */
public class Bike {

    private final int speed;
    private final String model;
    private final int weight;
    private final double volume;

    public Bike(String model, int speed, int weight, double volume) {
        this.speed = speed;
        this.model = model;
        this.weight = weight;
        this.volume = volume;
    }

    public int getSpeed() {
        return speed;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public double getValue() {
        return volume;
    }
}


