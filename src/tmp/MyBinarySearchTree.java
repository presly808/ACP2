package tmp;

/**
 * Created by Admin on 30.08.14.
 */
public class MyBinarySearchTree<T> implements MyTree<T> {

    private TreeNode root;

    public class TreeNode{
        T value;
        TreeNode parent;
        TreeNode lChild;
        TreeNode rChild;

        public TreeNode(T value, TreeNode parent, TreeNode lChild, TreeNode rChild) {
            this.value = value;
            this.parent = parent;
            this.lChild = lChild;
            this.rChild = rChild;
        }
    }

    @Override
    public void add(T element) {
        if (root == null){
            root = new TreeNode(element, null, null, null);
        } else {
            Comparable<T> comparable = (Comparable<T>) element;
            TreeNode iter = root;
            while (iter != null){
                if (comparable.compareTo(iter.value) < 0){
                    if (iter.lChild == null){
                        iter.lChild = new TreeNode(element, iter, null, null);
                        return;
                    } else {
                        iter = iter.lChild;
                    }
                } else
                    if (iter.rChild == null) {
                        iter.rChild = new TreeNode(element, iter, null, null);
                        return;
                    } else {
                        iter = iter.rChild;
                    }
            }
        }

    }
}
