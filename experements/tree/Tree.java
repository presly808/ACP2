package experements.tree;

/**
 * Created by admin on 30.08.2014.
 */
public interface Tree<E>  {

    void add(E element);

    void remove(E element);

    boolean contains(E element);

    void print();

}
