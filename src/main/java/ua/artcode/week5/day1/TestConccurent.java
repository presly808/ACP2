package ua.artcode.week5.day1;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by admin on 27.09.2014.
 */
public class TestConccurent {

    public static void main(String[] args) throws InterruptedException {
        SomeData someData = new SomeData();
        for(int i = 0; i < 3; i++){
            new Thread(new MyProducer(someData)).start();
        }

        Thread.sleep(3000);

        System.out.println(someData.money);



    }


    static class SomeData {

        ReentrantLock reentrantLock = new ReentrantLock();
        int money ;

        public void put(int money){
            reentrantLock.lock();
            this.money += money;
            reentrantLock.unlock();
        }

    }

    static class MyProducer implements Runnable {

        private SomeData someData;

        MyProducer(SomeData someData) {
            this.someData = someData;
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                someData.put(1);
            }
        }
    }


}
