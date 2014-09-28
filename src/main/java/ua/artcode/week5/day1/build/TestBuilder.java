package ua.artcode.week5.day1.build;

/**
 * Created by admin on 27.09.2014.
 */
public class TestBuilder {

    public static void main(String[] args) {
        BikeBuilder bikeBuilder = new BikeBuilder().addSpeed(220).
                addModel("Honda");

        new StringBuilder().append("new").append("word").toString();
    }

}
