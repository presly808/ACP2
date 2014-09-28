package my_tmp.week5;

/**
 * Created by Admin on 27.09.14.
 */
public class BikeBuilder {

    private String model;
    private int speed;
    private int weight;
    private double volume;

    public BikeBuilder addModel (String model){
        this.model = model;
        return this;
    }
    public BikeBuilder addSpeed (int speed){
        this.speed = speed;
        return this;
    }
    public BikeBuilder addWeight (int weight){
        this.weight = weight;
        return this;
    }
    public BikeBuilder addValue (double volume){
        this.volume = volume;
        return this;
    }

    public Bike build(){
        return new Bike(model, speed, weight, volume);
    }

}
