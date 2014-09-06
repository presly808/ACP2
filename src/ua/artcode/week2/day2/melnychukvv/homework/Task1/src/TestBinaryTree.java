package ua.artcode.week2.day2.melnychukvv.homework.Task1.src;

/**
 * Created by bm13 on 30.08.2014.
 */
public class TestBinaryTree {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree();

/*        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(0);
        tree.add(-1);
        tree.add(-1);
        tree.add(-2);*/

        tree.add(20);
        tree.add(10);
        tree.add(40);
        tree.add(5);
        tree.add(15);
        tree.add(1);
        tree.add(7);
        tree.print();

        tree.rotateRight();
        tree.print();

        tree.rotateLeft();
        tree.print();
    }
}
