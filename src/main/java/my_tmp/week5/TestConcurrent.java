package my_tmp.week5;

import my_tmp.MyAnnotation.MyBigPart;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Admin on 27.09.14.
 */
public class TestConcurrent {

    public static void main(String[] args) throws InterruptedException {

        SomeData someData = new SomeData();

        for (int i = 0; i < 3; i++) {
            new Thread(new MyProducer(someData)).start();
        }

        Thread.sleep(3000);
        System.out.println(someData.money);
    }

    static class  SomeData{

        ReentrantLock reentrantLock = new ReentrantLock();
        int money;

        public void put(int money){
            reentrantLock.lock();
            this.money += money;
            reentrantLock.unlock();
        }
    }

    static class MyProducer implements Runnable{

        private SomeData someData;

        MyProducer(SomeData someData){
            this.someData = someData;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                someData.put(1);
            }
        }
    }
}
