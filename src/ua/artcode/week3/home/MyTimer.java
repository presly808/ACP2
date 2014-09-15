package ua.artcode.week3.home;

/**
 * Created by admin on 15.09.2014.
 */
public class MyTimer {

    private long start;
    private long delay;

    private MyAction myAction;

    public MyTimer(MyAction myAction) {
        this.myAction = myAction;
    }

    public void start(){
        start = System.currentTimeMillis();
        while (true) {
            if(System.currentTimeMillis() - start >= delay){
                myAction.action();
                start = System.currentTimeMillis();// update point
            }
        }
    }
}
