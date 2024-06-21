package UE02_AddAndSearch;

public class Node
{
    // *** Membervariablen ***
    private int number;
    private  Node left;
    private Node right;
    private Node parent;

    // *** Konstruktor ***

    public Node(int number) {
        this.number = number;
    }

    // *** Getter- & Setter-Methoden ***

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
