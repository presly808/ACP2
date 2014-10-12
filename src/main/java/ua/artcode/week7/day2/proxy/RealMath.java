package ua.artcode.week7.day2.proxy;

/**
 * Created by admin on 12.10.2014.
 */
public class RealMath implements IMath {

    @Override
    public double divide(double a, double b) {
        return a / b;
    }

    @Override
    public double pow(double a, double b) {
        double res = a;
        while(b > 0){
            a *= a;
            b--;
        }
        return res;
    }
}
