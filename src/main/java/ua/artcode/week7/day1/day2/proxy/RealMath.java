package ua.artcode.week7.day1.day2.proxy;

/**
 * Created by Admin on 12.10.14.
 */
public class RealMath implements IMath {

    @Override
    public double divide(double a, double b) {
        return a / b;
    }

    @Override
    public double pow(double a, double b) {
        double res = 0;
        while (b > 0){
            a *= a;
            b--;
        }
        return res;
    }
}
