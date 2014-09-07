package my_tmp.MyBinaryTree;

/**
 * Created by Admin on 30.08.14.
 */
public class MyBinarySearchTree2<T> implements MyTree2<T> {

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

    private TreeNode findMax(TreeNode node){
        TreeNode max = node;
        if (max.lChild != null && max.rChild == null) {
            max = max.lChild;
        } else while (max.rChild != null){
            max = max.rChild;
        }
        return max;
    }

    @Override
    public void remove(T element) {
        if (root != null){  // if root is not null
            TreeNode iter = root;
            Comparable<T> comparable = (Comparable<T>) element;
            if (contains(element)){ // if tree contains the element to remove
                while (iter != null){   // finding element in tree
                    if (comparable.compareTo(iter.value) == 0){ // if element equals node value
                        if (iter.lChild == null && iter.rChild == null){ // if element has no children
                            if (iter.equals(root)){ // check is the item is root.
                                root = iter.rChild;
                                return;
                            } else {
                                if (comparable.compareTo(iter.parent.value) < 0){   // check which parent link to reset
                                    iter.parent.lChild = null; // reset left parent link
                                } else {
                                    iter.parent.rChild = null;  // reset right parent link
                                }
                                // if we find element too remove and this element have no children
                                // and this element is not a root
                                // we just reset parent link from this element to null.
                                return;
                            }

                        } else { // in other case removed element has at least one child.
                            if (iter.lChild != null){ // if left child of element is not null.
                                if (iter.lChild.lChild == null && iter.lChild.rChild == null){
                                    iter.value = iter.lChild.value;
                                    iter.lChild = null;
                                    return;
                                } else {
                                    TreeNode maxNode = findMax(iter.lChild);    // in this case we find the maximum element in left subtree
                                    if (maxNode.lChild != null){ // if we find maximum element in this subtree it mean
                                        // this element hasn't right child and we check is he has left child.
                                        maxNode.parent.rChild = maxNode.lChild; // if maximum element has left child
                                        // we redirect parent right link on left child of maximum element.
                                        return;
                                    } else { // in other case (if maximum element hasn't left child) we just reset
                                        // parent right link from this element to null.
                                        maxNode.parent.rChild = null;
                                    }
                                    iter.value = maxNode.value; // in end replace removed element value to
                                    return;
                                }
                            } else { // in case if the deleted element hasn't left child, it mean he has right child
                                    // in this case we redirect parent link
                                if (iter.equals(root)){ // check is the item is root.
                                    root = iter.rChild;
                                    root.parent = null;
                                    return;
                                } else {
                                    if (comparable.compareTo(iter.parent.value) < 0){
                                        // if parent value > than deleted element value
                                        iter.parent.lChild = iter.rChild; // parent left child lick redirect on right child of element
                                        iter.rChild.parent = iter.parent; // and right child parent to element parent.
                                    } else { // in other case if parent value < then deleted value
                                        iter.parent.rChild = iter.rChild; // parent right child link redirect on right child of element
                                        iter.rChild.parent = iter.parent; // and right child parent link on element parent.
                                    }
                                    return;
                                }
                            }
                        }
                    // in case if this element not equal requested element we go down the tree
                    } else if (comparable.compareTo(iter.value) < 0){
                        iter = iter.lChild; // if requested element < current node value
                    } else {
                        iter = iter.rChild; // if requested element > current node value
                    }
                }
            } else { // if deleted element is not contained in this tree
                System.out.println("No " + element + " in tree");
                return;
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
    public T findElement(T element) {
        if (root != null){
            TreeNode iter = root;
            Comparable<T> comparable = (Comparable<T>) element;
            while (iter != null){
                if (comparable.compareTo(iter.value) == 0){
                    return (T) iter;
                } else if (comparable.compareTo(iter.value) < 0){
                    iter = iter.lChild;
                } else {
                    iter = iter.rChild;
                }
            }
        }
        return null;
    }

    @Override
    public void print() {
        printRoot();
        System.out.print("Tree: ");
        print(root);
        System.out.println();
    }

    private void printRoot() {
        if (root != null)
            System.out.println("Root is: " + root.value);
    }

    private void print(TreeNode treeNode){
        if (treeNode == null)   return;

        print(treeNode.lChild);
        System.out.print(treeNode.value + " ");
        print(treeNode.rChild);
    }

    @Override // method counting the number of tree nodes
    public int treeSize() {
        hasNext();
        return iter;
    }

    int iter = 0;

    private void hasNext() {
        iter = 0;
        hasNext(root);
    }

    private void hasNext(TreeNode treeNode){
        if (treeNode == null){
            return;
        } else {
            iter++;
            hasNext(treeNode.lChild);
            hasNext(treeNode.rChild);
        }
    }
}