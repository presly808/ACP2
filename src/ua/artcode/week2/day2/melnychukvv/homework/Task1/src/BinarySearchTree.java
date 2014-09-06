package ua.artcode.week2.day2.melnychukvv.homework.Task1.src;

/**
 * Created by bm13 on 30.08.2014.
 */
public class BinarySearchTree implements Tree {
    private static Node root = null;
    private Node current = null;


    @Override
    public void add(int c) {
        boolean flag = false;

        if (root == null) {
            root = new Node(null,null,null,c);
        } else {
            current = root;

            while (!flag) {
                if (c >= current.getValue()) {
                    if (current.getRightChild() != null){
                        current = current.getRightChild();
                    } else {
                        Node node = new Node(current, null, null, c);
                        current.setRightChild(node);
                        flag = true;
                    }
                } else if (c < current.getValue()) {
                    if (current.getLeftChild() != null) {
                        current = current.getLeftChild();
                    } else {
                        Node node = new Node(current, null, null, c);
                        current.setLeftChild(node);
                        flag = true;
                    }
                }
            }


        }


    }

    @Override
    public void remove(int c) {

    }

    @Override
    public void print() {
        System.out.println();
        printNode(root);
    }

    private void printNode(Node node){
        String res = "Node = " + node.getValue();

        if (node.getParent() != null) {
            res = res.concat(" | Parent = " + node.getParent().getValue());
        } else {
            res = res.concat(" | Parent = " + node.getParent());
        }

        if (node.getLeftChild() != null) {
            res = res.concat(" | LeftChild = " + node.getLeftChild().getValue());
        } else {
            res = res.concat(" | LeftChild = " + node.getLeftChild());
        }

        if (node.getRightChild() != null) {
            res = res.concat(" | RightChild = " + node.getRightChild().getValue());
        } else {
            res = res.concat(" | RightChild = " + node.getRightChild());
        }
        System.out.println(res);

        if (node.getRightChild() != null) {
            printNode(node.getRightChild());
        }
        if (node.getLeftChild() != null) {
            printNode(node.getLeftChild());
        }
    }

    @Override
    public void rotateLeft() {
        Node newRoot = root.getRightChild();

        newRoot.setParent(null);
        root.setRightChild(newRoot.getLeftChild());
        newRoot.setLeftChild(root);

        root = newRoot;
    }

    @Override
    public void rotateRight() {
        Node newRoot = root.getLeftChild();

        newRoot.setParent(null);
        root.setLeftChild(newRoot.getRightChild());
        newRoot.setRightChild(root);

        root = newRoot;

    }

}
