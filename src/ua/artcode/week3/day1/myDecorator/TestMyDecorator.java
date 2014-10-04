package ua.artcode.week3.day1.myDecorator;

public class TestMyDecorator {
    public static void main(String[] args) {
        Decorator decorator = new Decor(new MainFilter());
        decorator.doSomeWork();
        decorator.newSomeWork();
    }
}
