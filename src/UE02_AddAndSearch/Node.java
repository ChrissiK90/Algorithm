package UE02_AddAndSearch;

public class Node
{
    // *** Membervariablen ***
    private int number; // Wert des Knotens
    private Node left; // linker Knoten
    private Node right; // rechter Knoten
    private Node parent; // Elternknoten

    // *** Konstruktor ***
    public Node(int number) {
        this.number = number; // Wert setzen
    }

    // *** Getter- & Setter-Methoden ***
    public int getNumber() {
        return number; // Wert zurückgeben
    }

    public void setNumber(int number) {
        this.number = number; // Wert setzen
    }

    public Node getLeft() {
        return left; // linken Knoten zurückgeben
    }

    public void setLeft(Node left) {
        this.left = left; // linken Knoten setzen
    }

    public Node getRight() {
        return right; // rechten Knoten zurückgeben
    }

    public void setRight(Node right) {
        this.right = right; // rechten Knoten setzen
    }

    public Node getParent() {
        return parent; // Elternknoten zurückgeben
    }

    public void setParent(Node parent) {
        this.parent = parent; // Elternknoten setzen
    }
}
