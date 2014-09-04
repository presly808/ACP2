package ua.artcode.week2.day1;

/**
 * Created by admin on 30.08.2014.
 */
public class TestBinaryTree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.add(100);
        tree.add(50);
        tree.add(150);
        tree.add(25);
        tree.add(10);
        tree.add(5);
        tree.add(3);
        tree.add(1);

        tree.print();
        System.out.println(tree.deep());
        System.out.println("End");
    }

}
