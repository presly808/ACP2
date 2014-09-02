package my_tmp.MyBinaryTree;

/**
 * Created by Admin on 30.08.14.
 */
public class MyTestBinaryTree {
    public static void main(String[] args) {
        //int[] mass = {100,150,200,120,50,20,60,70,19,21,65};
        int[] mass = {100,150,200};
        MyTree<Integer> tree = new MyBinarySearchTree<Integer>();
        for(int i : mass) tree.add(i);
        tree.printRoot();
        tree.print();
        for(int i : mass) tree.remove(i);
        tree.printRoot();
        tree.print();

    }
}
