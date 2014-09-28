package ua.artcode.week5.day1.build;

/**
 * Created by admin on 27.09.2014.
 */
public class BikeBuilder {

    private String model;
    private int speed;
    private int weight;
    private double volume;

    public BikeBuilder addModel(String model){
        this.model = model;
        return this;
    }

    public BikeBuilder addSpeed(int speed){
        this.speed = speed;
        return this;
    }

    public BikeBuilder addWeight(int weight){
        this.weight = weight;
        return this;
    }

    public BikeBuilder addVolume(double volume){
        this.volume = volume;
        return this;
    }

    public Bike build(){
        return new Bike(model,speed,weight,volume);
    }


}
