import java.util.Date;

/**
 * Created by admin on 23.08.2014.
 */

public class Test {
    //Ctrl + Shift + F10 - Run main
    //psvm - main method
    //format code  Ctrl + Alt + L
    public static void main(String[] args) {
        //sout  + TAb

        System.out.println("Start main thread");
        Date date = new Date();
        long pointStart = date.getTime();
        System.out.println(recFact(15));
        long pointEnd = System.currentTimeMillis();
        System.out.println("After recursion");
        System.out.println("Time of work in millis = " + (pointEnd - pointStart));




    }

    // ternary
    /*
    * num < 2 ? 1 : (recFact(num - 1));
    *
    * if(num < 2){
    *    return 1;
    * } else {
    *    return recFact(num - 1);
    * }
    *
    * */
    public static int recFact(int num) {
        return num < 2 ? 1 : (num * recFact(num - 1));
    }


}
