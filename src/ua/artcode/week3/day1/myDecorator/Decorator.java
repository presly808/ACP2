package ua.artcode.week3.day1.myDecorator;

public abstract class Decorator implements iForMyFilterClass{

    protected iForMyFilterClass forMyFilterClass;

    public Decorator (iForMyFilterClass forMyFilterClass){
        this.forMyFilterClass = forMyFilterClass;
    }

    @Override
    public void doSomeWork() {
        forMyFilterClass.doSomeWork();
    }

    public void newSomeWork(){
        System.out.println("Some new work");
    }
}
