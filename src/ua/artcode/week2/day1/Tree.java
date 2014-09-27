package ua.artcode.week2.day1;


/**
 * Created by admin on 30.08.2014.
 */
public interface Tree<T>  {

    void add(T element);

    boolean remove(T element);

    boolean contains(T element);

    void print();


}
