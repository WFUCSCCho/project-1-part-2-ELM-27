/*
 * @file: Node.java
 * @description: This class stores nodes for a binary search tree.
 *               The class includes the following methods:
 *               setElement, setLeft, setRight, getLeft, getRight,
 *               getElement, isLeaf, compareTo
 * @author: Elliott Lowman
 * @date: September 22, 2024
 */

class Node<T> implements Comparable<T> {

    // Implement the constructor
    private T obj;
    private Node<T> lNode;
    private Node<T> rNode;

    Node(T obj) {
        this.obj = obj;
        lNode = rNode = null;
    }

    // Implement the setElement method
    public void setElement(T obj) { this.obj = obj; }

    // Implement the setLeft method
    public void setLeft() { lNode = null; }
    public void setLeft(T obj) { lNode = new Node<>(obj); }
    public void setLeft(Node<T> obj) { lNode = obj; }

    // Implement the setRight method
    public void setRight() { rNode = null; }
    public void setRight(T obj) { rNode = new Node<>(obj); }
    public void setRight(Node<T> obj) { rNode = obj; }

    // Implement the getLeft method
    public Node<T> getLeft() { return lNode; }

    // Implement the getRight method
    public Node<T> getRight() { return rNode; }

    // Implement the getElement method
    public T getElement() { return obj; }

    // Implement the isLeaf method
    public boolean isLeaf() {
        if(lNode == null && rNode == null) {
            return true;
        } else {
            return false;
        }
    }

    // standard compareTo implementation
    @Override
    public int compareTo(Object o) {
        int difference;

        difference = (int) obj - (int) o;

        return difference;
    }
}