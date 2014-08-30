package ua.artcode.week1.home;

/**
 * Created by admin on 27.08.2014.
 */
//Ctrl + N
public class TestMySet {
    public static void main(String[] args) {

        MySet<String> stringMySet = new MySet<String>();
        stringMySet.add("Serhii");
        stringMySet.add("Valentin");
        stringMySet.add("Oleg");
        stringMySet.add("Viktor");
        stringMySet.add("Sasha");
        stringMySet.add("Masha");
        stringMySet.add("Vika");
        stringMySet.add("Evgen");


        for(String s : stringMySet){
            System.out.println(s);
        }


    }
}
