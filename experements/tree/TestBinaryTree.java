package experements.tree;

/**
 * Created by admin on 30.08.2014.
 */
public class TestBinaryTree {

    public static void main(String[] args) {
        Tree<String> tree = new BinarySearchTree<>();

        tree.add("Olixiy");
        tree.add("Olga");
        tree.add("Viktora");
        tree.add("Vania");
        tree.add("Vasia");
        tree.add("Nikita");

        tree.print();
        System.out.println("End");
    }

}
