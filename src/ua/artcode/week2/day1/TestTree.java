package ua.artcode.week2.day1;

public class TestTree {
    public static void main(String[] args) {
        iTree<Integer> tree = new BinarySearchTree<>();

        tree.add(10);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(11);
        tree.add(13);
        System.out.println("End");
        System.out.println(tree.findTreeDeep());



    }
}
