package my_tmp.MyBinaryTree;

/**
 * Created by Admin on 30.08.14.
 */
public interface MyTree<T> {

    void add(T element);
    
    void remove(T element);

    boolean contains(T element);

    void print();

    void printRoot();

    void printTree();

    void hasNext();

    int treeDeep();

    int treeSize();



    // void printRoot();
}
