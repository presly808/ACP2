package ua.artcode.week7.day2.proxy;

/**
 * Created by admin on 12.10.2014.
 */
public class ProxyMath implements IMath {

    private IMath math; // RealSubject

    public ProxyMath(IMath math) {
        this.math = math;
    }

    @Override
    public double divide(double a, double b) {
        if(b == 0){
            System.out.println("Can not divide by zero");
            throw new ArithmeticException("Divide by zero");
        }
        return math.divide(a,b);
    }

    @Override
    public double pow(double a, double b) {
        if(b == 0){
            return 1;
        } else if(b < 0){
            System.out.println("Can not evaluate");
            return -1;
        }

        return math.pow(a,b);
    }
}
