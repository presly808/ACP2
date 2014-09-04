package homeWork.binaryTree;// Created by Sergey on 30.08.2014.

public class TestBinaryTree {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree<>();

        tree.add(20);
        tree.add(30);
        tree.add(10);
        tree.add(15);
        tree.add(25);
        tree.add(3);
        tree.print();
        tree.remove(15);

        System.out.println("======End==========");

        tree.print();
    }
}