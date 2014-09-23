package my_tmp.MyBinaryTree;

/**
 * Created by Admin on 30.08.14.
 */
public interface MyTree2<T> {

    void add(T element);

    void remove(T element);

    boolean contains(T element);

    T findElement(T element);

    void print();

    int treeSize();



    // void printRoot();
}
