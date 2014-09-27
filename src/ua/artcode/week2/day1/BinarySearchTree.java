package ua.artcode.week2.day1;

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
    public boolean remove(T element) {
        TreeNode focusNode = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        Comparable<T> elem = (Comparable<T>) element;
        while (elem.compareTo(focusNode.value) != 0) {
            parent = focusNode;
            if (elem.compareTo(focusNode.value) < 0) {
                isLeftChild = true;
                focusNode = focusNode.lChild;
            } else if (elem.compareTo(focusNode.value) > 0) {
                isLeftChild = false;
                focusNode = focusNode.rChild;
            }
            if (focusNode == null) {
                return false;
            }
        }
///////////////////////////////////////////////////////////////////
        if (focusNode.rChild == null && focusNode.lChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isLeftChild) {
                parent.lChild = null;
            } else {
                parent.rChild = null;
            }
        }
/////////////////////////////////////////////////////////////////
        else if (focusNode.rChild == null) {
            if (focusNode == root) {
                root = focusNode.lChild;
            } else if (isLeftChild) {
                parent.lChild = focusNode.lChild;
            } else {
                parent.rChild = focusNode.lChild;
            }
        } else if (focusNode.lChild == null) {
            if (focusNode == root) {
                root = focusNode.rChild;
            } else if (isLeftChild) {
                parent.lChild = focusNode.rChild;
            } else {
                parent.rChild = focusNode.rChild;
            }
        }
/////////////////////////////////////////////////////////////////
        else {
            //else if(focusNode.rChild != null && focusNode.lChild != null)
            TreeNode replacement = getReplacementNode(focusNode);
            if (focusNode == root) {
                root = replacement;
            } else if (isLeftChild) {
                parent.lChild = replacement;
            } else {
                parent.rChild = replacement;
            }
            replacement.lChild = focusNode.lChild;
        }
        return true;
    }

    private TreeNode getReplacementNode(TreeNode temp) {
        TreeNode replaceParent = temp;
        TreeNode replacement = temp;
        TreeNode focusNode = temp.rChild;
        while (focusNode != null){
            replaceParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.lChild;
        }
        return replacement;
    }



    @Override
    public boolean contains(T element) {
        if(root == null){
            return false;
        }else{
            Comparable<T> comparable = (Comparable<T>) element;
            TreeNode iter = root;
            while(iter != null){
                if(comparable.compareTo(iter.value) >0){
                    iter = iter.rChild;
                }else if(comparable.compareTo(iter.value) < 0){
                    iter = iter.lChild;
                }else if(comparable.compareTo(iter.value) == 0){
                    System.out.println("Contains - " + iter.value);
                    return true;
                }
            }
            return false;
        }
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
