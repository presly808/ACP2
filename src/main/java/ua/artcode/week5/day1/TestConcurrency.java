package ua.artcode.week5.day1;

import java.util.concurrent.locks.ReentrantLock;

public class TestConcurrency {

    public static void main(String[] args) throws InterruptedException {

        SomeData someDATA = new SomeData();

        for (int i = 0; i < 10; i++) {
            new Thread(new MyProducer(someDATA)).start();
        }

        Thread.sleep(1000);

        System.out.println(someDATA.money);

    }

    static class SomeData{

        int money;
        ReentrantLock reentrantLock = new ReentrantLock();

        public void put(int money){
            reentrantLock.lock();
            this.money+=money;
            reentrantLock.unlock();
        }

    }

    static class MyProducer implements Runnable{
        MyProducer(SomeData someData) {
            this.someData = someData;
        }

        private SomeData someData;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                someData.put(1);
            }
        }
    }

}
