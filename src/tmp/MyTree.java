package tmp;

/**
 * Created by Admin on 30.08.14.
 */
public interface MyTree<T> {

    void add(T element);
    
    void remove(T element);

    boolean contains(T element);

    void print();
}
