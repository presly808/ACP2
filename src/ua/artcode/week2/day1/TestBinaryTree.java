package ua.artcode.week2.day1;

/**
 * Created by admin on 30.08.2014.
 */
public class TestBinaryTree {

    public static void main(String[] args) {
        Tree<String> tree = new BinarySearchTree<String>();

        tree.add("Olixiy");
        tree.add("Olga");
        tree.add("Viktora");
        tree.add("Vania");
        tree.add("Vasia");
        tree.add("Nikita");
        tree.add("gogogog");
        tree.add("Kiska");
        tree.add("Vilka");

        String s = "Olga";

       // tree.print();

        System.out.println(tree.remove(s));
        tree.print();
    }

}
