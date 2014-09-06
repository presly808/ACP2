package ua.artcode.week2.home;

public class Flawor{
    String name;

    public Flawor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Flawor{" +
                "name='" + name + '\'' +
                '}';
    }
}
