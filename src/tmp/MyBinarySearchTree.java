package tmp;

import java.util.Comparator;

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
       if (root == null) {
           root = new TreeNode(element, null, null, null);
       } else {
           Comparable<T> comparable = (Comparable<T>) element;
           TreeNode iter = root;
           while (iter != null){
               if (comparable.compareTo(iter.value) < 0 ){
                   if (iter.lChild == null){
                       iter.lChild = new TreeNode(element, iter, null, null);
                       return;
                   } else {
                       iter = iter.lChild;
                   }
               } else {
                   if (iter.rChild == null){
                       iter.rChild = new TreeNode(element, iter, null, null);
                       return;
                   } else {
                       iter = iter.rChild;
                   }
               }
           }
       }
   }

    public TreeNode findMax(TreeNode node){
        TreeNode max = node;
        if (max.rChild == null) {
            max = max.lChild;
            System.out.println("max = node.lChild");
        } else while (max.rChild != null){
            max = max.rChild;
        }
        System.out.println("findMax method");
        System.out.println("max = node.lChild");
        return max;
    }

    @Override
    public void remove(T element) {
        if (root != null){
            TreeNode iter = root;
            Comparable<T> comparable = (Comparable<T>) element;
            while (iter != null){
                if (comparable.compareTo(iter.value) == 0){
                    if (iter.lChild != null && iter.rChild != null){
                        TreeNode maxNode = findMax(iter);
                        if (maxNode.lChild != null){
                            maxNode.parent.lChild = maxNode.lChild;
                        } else {
                            maxNode.parent.lChild = null;
                        }
                        maxNode.parent = iter.parent;
                        maxNode.value = iter.value;
                        maxNode.lChild = iter.lChild;
                        maxNode.rChild = iter.rChild;
                        System.out.println("Node " + iter.value + " is deleted");
                    } else {

                    }



                } else if (comparable.compareTo(iter.value) < 0){
                    iter = iter.lChild;
                } else {
                    iter = iter.rChild;
                }
            }
        }
    }

    @Override
    public boolean contains(T element) {
        if (root != null){
            TreeNode iter = root;
            Comparable<T> comparable = (Comparable<T>) element;
            while (iter != null){
                if (comparable.compareTo(iter.value) == 0){
                    return true;
                } else if (comparable.compareTo(iter.value) < 0){
                    iter = iter.lChild;
                } else {
                    iter = iter.rChild;
                }
            }

        }
        return false;
    }

    @Override
    public void print() {
        print(root);
        System.out.println();
    }

    public void print(TreeNode treeNode){
        if (treeNode == null)
            return;

        print(treeNode.lChild);
        System.out.print(treeNode.value + "\t");
        print(treeNode.rChild);
    }
}
