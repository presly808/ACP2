package ua.artcode.week2.day2.melnychukvv.homework.Task1.src;

/**
 * Created by bm13 on 30.08.2014.
 */
public class Node {
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private int value;


    public Node getRightChild() {
        return rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
        rightChild.setParent(this);
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
        leftChild.setParent(this);
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public Node getParent() {
        return parent;
    }

    public Node(Node parent, Node leftChild, Node rightChild, int value){
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = value;
    }

}
