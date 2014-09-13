package homeWork.Timer;// Created by Sergey on 11.09.2014.

import homeWork.DynamicSorter.DSorter;

import java.io.IOException;

class Say {
    public void saySomething() {
        System.out.println("I'm saying");
    }
}

class MyTimer{
    public void stop(){
    }
    public void start(long delay,  Say say) throws InterruptedException {
        Thread.sleep(delay);
        say.saySomething();
    }
    public void start(long delay, DSorter sorter) throws InterruptedException, IOException {
        System.out.println("before sort");
        Thread.sleep(delay);
        sorter.sort();
        System.out.println("after sort");
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Say say = new Say();
        MyTimer myTimer = new MyTimer();
        DSorter dSorter = new DSorter();
        System.out.println("started");
        myTimer.start(3000, say);
        myTimer.start(5000, dSorter);
    }
}