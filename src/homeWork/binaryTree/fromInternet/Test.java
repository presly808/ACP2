package homeWork.binaryTree.fromInternet;// Created by Sergey on 03.09.2014.

public class Test {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<Integer>();
        for (int i = 1; i <= 7; i++)
            tree.insert(new Integer(i));
        tree.PrintTree();
    }
}
