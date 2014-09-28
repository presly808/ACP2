package my_tmp.week5;

/**
 * Created by Admin on 27.09.14.
 */
public class TestBikeBuilder {
    public static void main(String[] args) {

        Bike bike = new BikeBuilder().addSpeed(220)
                                     .addModel("Honda")
                                     .addValue(400)
                                     .addWeight(300)
                                     .build();

        new StringBuilder().append("name").toString();
    }
}
