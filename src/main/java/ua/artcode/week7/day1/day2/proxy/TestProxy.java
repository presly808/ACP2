package ua.artcode.week7.day1.day2.proxy;

/**
 * Created by Admin on 12.10.14.
 */
public class TestProxy {

    public static void main(String[] args) {

        RealMath realMath = new RealMath();
        IMath math = new ProxyMath(realMath);

        math.divide(45,0);
    }
}
