package ua.artcode.week7.day2.proxy;

/**
 * Created by admin on 12.10.2014.
 */
public class TestProxy {

    public static void main(String[] args) {
        RealMath realMath = new RealMath();
        IMath math = new ProxyMath(realMath);

        double res = math.divide(45,8);
        System.out.println(res);

    }


}
