package ua.artcode.week5.day1.builder;

public class BikeBuilder{

    private float speed;
    private String model;
    private float weight;
    private float volume;

    public BikeBuilder() {
    }

    public BikeBuilder(BikeBuilder original) {

    }

    public BikeBuilder speed(float speed){
        this.speed = speed;
        return this;
    }

    public BikeBuilder model(String model){
        this.model = model;
        return this;
    }

    public BikeBuilder weight(float weight){
        this.weight = weight;
        return this;
    }

    public BikeBuilder volume(float volume){
        this.volume = volume;
        return this;
    }

    /*public Bike build(){
        return new Bike(this);
    }*/
}

