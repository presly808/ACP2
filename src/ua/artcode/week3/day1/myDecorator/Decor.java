package ua.artcode.week3.day1.myDecorator;

public class Decor extends Decorator {

    public Decor(iForMyFilterClass forMyFilterClass) {
        super(forMyFilterClass);
    }

    @Override
    public void doSomeWork() {
        System.out.println(" ahahaha ");
        super.doSomeWork();
    }

    @Override
    public void newSomeWork() {
        System.out.println("Ku ku ku");
    }
}
