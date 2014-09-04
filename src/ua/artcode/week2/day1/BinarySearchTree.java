package ua.artcode.week2.day1;

public class BinarySearchTree<T> implements iTree<T> {

    private TreeNode root;

    private class TreeNode{

        T value;
        TreeNode parent;
        TreeNode leftChild;
        TreeNode rightChild;

        private TreeNode(T value, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
            this.value = value;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }


    @Override
    public void add(T element) {
        if(root == null){
            root = new TreeNode(element, null, null, null);
        } else {
            Comparable<T> comparable = (Comparable<T>) element;
            TreeNode iter = root;
            while (iter != null){
                if (comparable.compareTo(iter.value) < 0){ //choose way
                    if (iter.leftChild == null){
                        iter.leftChild = new TreeNode(element, iter, null, null); //link to tree
                        return; //exit from method
                    } else {
                        iter = iter.leftChild; //way condition
                    }
                } else if (comparable.compareTo(iter.value) > 0){ //choose way
                    if (iter.rightChild == null){
                        iter.rightChild = new TreeNode(element, iter, null, null); //link to tree
                        return; //exit from method
                    } else {
                        iter = iter.rightChild; //way condition
                    }
                }
            }
        }

    }

    @Override
    public void remove(T element) {

        if (root == null){
            return;
        } else if (!contains(element)){
            return;
        } else {
            remove(element, root);
        }

    }

    private void remove(T element, TreeNode treeNode){

        if (treeNode == null){
            return;
        }

        if (treeNode.value.equals(element)){
            if ((treeNode.leftChild == null) && (treeNode.rightChild == null)){
                if(treeNode.parent.rightChild.equals(treeNode)){
                    treeNode.parent.rightChild = null;
                } else {
                    treeNode.parent.leftChild = null;
                }
            } else if ((treeNode.leftChild == null) && (treeNode.rightChild != null)){
                if (treeNode.parent.leftChild.equals(treeNode)){
                    treeNode.parent.leftChild = treeNode.rightChild;
                } else {
                    treeNode.parent.rightChild = treeNode.rightChild;
                }
            } else if ((treeNode.leftChild != null) && (treeNode.rightChild == null)){
                if (treeNode.parent.leftChild.equals(treeNode)){
                    treeNode.parent.leftChild = treeNode.leftChild;
                } else {
                    treeNode.parent.rightChild = treeNode.leftChild;
                }
            } else {
                TreeNode temp = treeNode.leftChild;
                if (temp.rightChild != null){
                while (temp.rightChild != null){
                    temp = temp.rightChild;
                }
                }

                if (temp.leftChild != null){
                    temp.parent.rightChild = temp.leftChild;
                }

                treeNode.value = temp.value;
                temp.parent.leftChild = null;

            }
        } else {
            Comparable<T> comparable = (Comparable<T>) element;
            if (comparable.compareTo(treeNode.value)<0){
                remove(element, treeNode.leftChild);
            } else {
                remove(element, treeNode.rightChild);
            }
        }

    }

    @Override
    public boolean contains(T element) {

        if (root == null){
            return false;
        } else {
           return contains(element, root);
        }
    }

    private boolean contains(T element, TreeNode treeNode){

        if (treeNode == null){
            return false;
        }

        if (treeNode.value.equals(element)){
            return true;
        } else {
            Comparable<T> comparable = (Comparable<T>) element;
            if (comparable.compareTo(treeNode.value) < 0){
               return contains(element, treeNode.leftChild);
            } else {
               return contains(element, treeNode.rightChild);
            }
        }
    }


    @Override
    public void print() {

        if (root == null){
            return;
        } else {
            print(root);
        }

    }

    private void print(TreeNode treeNode){

        if (treeNode == null){  //recurcion finish
            return;
        }

        print(treeNode.leftChild);
        System.out.println(treeNode.value.toString());
        print(treeNode.rightChild);

    }


    @Override
    public void printTree() {

        if (root == null){
            System.out.println("Tree is dead");
        } else {
            printTree(root);
        }

    }

    private void printTree(TreeNode treeNode){

        if (treeNode == null){
            return;
        }
        if (treeNode.parent == null) {
            System.out.println("                   " + treeNode.value.toString());
        }
        if (treeNode.leftChild != null){
            System.out.print("                  " + treeNode.leftChild.value.toString());

        }
        if (treeNode.rightChild != null){
            System.out.print(" " + treeNode.rightChild.value.toString());
            System.out.println("");
        }

        printTree(treeNode.leftChild);
        printTree(treeNode.rightChild);


    }

    public int findTreeDeep(){
        int treeDeep = -1;
        if (root == null){
            return -1;
        } else {
            treeDeep = findTreeDeep(root, treeDeep);
            System.out.println(treeDeep);
            return findTreeDeep(root, treeDeep);
        }
    }

    private int findTreeDeep(TreeNode treeNode, int deep){

        if (treeNode == null){
            return deep;
        }

        if ((treeNode.leftChild != null) && (treeNode.rightChild!=null)){
            deep++;
        }

        findTreeDeep(treeNode.leftChild, deep);
        findTreeDeep(treeNode.rightChild, deep);


        return deep;
    }
}
