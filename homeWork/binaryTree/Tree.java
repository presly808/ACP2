package homeWork.binaryTree;// Created by Sergey on 30.08.2014.
/**
 * Created by admin on 30.08.2014.
 */
public interface Tree<E>  {
    void add(E element);
    void remove(E element);
    boolean contains(E element);
    void print();
    void rotateRight();
    void rotateLeft();
}