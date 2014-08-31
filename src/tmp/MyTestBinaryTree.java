package tmp;

/**
 * Created by Admin on 30.08.14.
 */
public class MyTestBinaryTree {
    public static void main(String[] args) {
        MyTree<Integer> tree = new MyBinarySearchTree<Integer>();
        tree.add(100);
        tree.add(150);
        tree.add(200);
        tree.add(120);
        tree.add(50);
        tree.add(20);
        tree.add(60);
        tree.add(70);
        tree.print();
        System.out.println("contains(7): " + tree.contains(7));
        System.out.println("contains(200): " + tree.contains(200));
        tree.remove(20);
        tree.remove(150);
        tree.print();
    }
}
