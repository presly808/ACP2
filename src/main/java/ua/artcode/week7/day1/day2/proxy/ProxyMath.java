package ua.artcode.week7.day1.day2.proxy;

/**
 * Created by Admin on 12.10.14.
 */
public class ProxyMath implements IMath {

    private IMath math;


    public ProxyMath(IMath math) {
        this.math = math;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0){
            System.out.println("Can not divide by zero");
            throw new ArithmeticException("Divide by zero");
        }
        return math.pow(a,b);
    }

    @Override
    public double pow(double a, double b) {
        if (b == 0){
            return 1;
        } else if (b < 0){
            System.out.println("Can not evaluate");
            return -1;
        }
        return math.pow(a,b);
    }
}
