package experements.tree;

/**
 * static, non-static
 */
public class BinarySearchTree<T> implements Tree<T> {

    private TreeNode root;

    private class TreeNode {
        T value;
        TreeNode parent;
        TreeNode lChild;
        TreeNode rChild;

        private TreeNode(T value, TreeNode parent,
                         TreeNode lChild, TreeNode rChild) {
            this.value = value;
            this.parent = parent;
            this.lChild = lChild;
            this.rChild = rChild;
        }


    }


    @Override
    public void add(T element) {
        if(root == null){
            root = new TreeNode(element, null, null, null);
        } else {
            Comparable<T> comparable = (Comparable<T>) element;//Arrays.sort

            TreeNode iter = root;
            while (iter != null){
                if(comparable.compareTo(iter.value) < 0){ //choose way
                    if(iter.lChild == null) { // has place for link
                        iter.lChild = new TreeNode(element, iter, null, null); // link to tree
                        return; // exit from method
                    } else {
                        iter = iter.lChild; // change way condition
                    }
                } else if(comparable.compareTo(iter.value) > 0){
                    if(iter.rChild == null) {
                        iter.rChild = new TreeNode(element, iter, null, null); // link to tree
                        return; // exit from method
                    } else {
                        iter = iter.rChild; // way condition
                    }
                }
            }
        }
    }

    @Override
    public void remove(T element) {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public void print() {
        print(root);
    }

    private void print(TreeNode treeNode){
        if(treeNode == null){
            return;
        }


        print(treeNode.rChild);
        System.out.println(treeNode.value);
        print(treeNode.lChild);

    }

}
