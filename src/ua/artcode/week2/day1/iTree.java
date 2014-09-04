package ua.artcode.week2.day1;

public interface iTree<E> {

    void add(E element);

    void remove(E element);

    boolean contains(E element);

    void print();

    void printTree();

    int findTreeDeep();

}


