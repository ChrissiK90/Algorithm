package UE02_AddAndSearch;

public class Tree {

    // zeigt auf die Referenz Wurzelknoten
    private Node root;

    // Methode zum Hinzufügen einer Zahl zum Baum
    public void add(int number) {
        // Knoten erstellen
        Node newNode = new Node(number);

        // VARIANTE LOOP
        // addLoop(newNode);

        // VARIANTE REKURSION
        // Fall: Baum noch leer
        if (root == null) {
            root = newNode; // Wurzelknoten setzen
        }
        // wenn nicht leer
        else {
            addRecursive(root, newNode); // neuen Knoten rekursiv hinzufügen
        }
    }

    // Add - Variante Rekursion
    private void addRecursive(Node currentNode, Node newNode) {
        // neuer Wert ist kleiner als aktueller Knotenwert
        if (newNode.getNumber() < currentNode.getNumber()) {
            // Fall: links ist schon ein Knoten
            if (currentNode.getLeft() != null) {
                // Rekursion mit linkem Knoten weiterführen
                addRecursive(currentNode.getLeft(), newNode);
            } else {
                // neuen Knoten links anhängen
                currentNode.setLeft(newNode);
                newNode.setParent(currentNode); // Elternknoten setzen
            }
        }
        // neuer Wert ist größer oder gleich dem aktuellen Knotenwert
        else {
            // Fall: rechts ist schon ein Knoten
            if (currentNode.getRight() != null) {
                // Rekursion mit rechtem Knoten weiterführen
                addRecursive(currentNode.getRight(), newNode);
            } else {
                // neuen Knoten rechts anhängen
                currentNode.setRight(newNode);
                newNode.setParent(currentNode); // Elternknoten setzen
            }
        }
    }

    // Add - Variante Loop
    private void addLoop(Node newNode) {
        // Fall: Baum ist leer
        if (root == null) {
            root = newNode; // Wurzelknoten setzen
        }
        // wenn nicht leer (mindestens 1 Wurzelknoten)
        else {
            // Hilfsvariable
            Node current = root;
            while (true) {
                // Neuer Wert ist kleiner als aktueller Knotenwert
                if (newNode.getNumber() < current.getNumber()) {
                    // Wenn links schon ein Knoten ist, dann weiterhüpfen
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                    } else {
                        // Wenn links kein Knoten ist, dann dort anhängen
                        current.setLeft(newNode);
                        newNode.setParent(current); // Elternknoten setzen
                        break;
                    }
                }
                // Neuer Wert ist größer oder gleich dem aktuellen Knotenwert
                else {
                    if (current.getRight() != null) {
                        current = current.getRight();
                    } else {
                        current.setRight(newNode);
                        newNode.setParent(current); // Elternknoten setzen
                        break;
                    }
                }
            }
        }
    }

    // Methode zum Suchen einer Zahl im Baum
    public Node searchNumber(int number) {
        System.out.print("SearchNumber - ");

        // Variante 1: Aufruf Rekursiv
        return searchNumberRecursive(root, number);

        // Variante 2: Aufruf Schleife
        // return searchNumberLoop(number);
    }

    // Suche - Variante Rekursion
    private Node searchNumberRecursive(Node currentNode, int number) {
        // Basisfall: Knoten ist null oder Wert gefunden
        if (currentNode == null || currentNode.getNumber() == number) {
            return currentNode; // Knoten zurückgeben
        }
        // Wert ist kleiner, links weiter suchen
        else if (currentNode.getNumber() > number) {
            return searchNumberRecursive(currentNode.getLeft(), number);
        }
        // Wert ist größer, rechts weiter suchen
        else {
            return searchNumberRecursive(currentNode.getRight(), number);
        }
    }

    // Suche - Variante Schleife
    private Node searchNumberLoop(int number) {
        Node current = root;
        // Schleife durchlaufen bis der Knoten gefunden wird oder null ist
        while (current != null && current.getNumber() != number) {
            //Fall: Knoten gefunden
            if (current.getNumber() == number) {
                return current;
            }
            //Gesuchter Wert ist größer als der aktuelle Knoten. Rechts weiter
            else if (current.getNumber() < number) {
                current = current.getRight();
            //Gesuchter Wert ist kleiner als der aktuelle Knoten. Links weiter
            } else {
                current = current.getLeft();
            }
        }
        //return null geht auch
        return current; // Knoten zurückgeben oder null, wenn nicht gefunden
    }

    // Funktion zur Ausgabe des gesamten Baums
    public void printTree() {
        printTree(root, "");
    }

    // Funktion zur Ausgabe des Baums unterhalb eines Knotens
    public void printTree(Node currentNode, String prefix) {
        if (currentNode == null) {
            return; // nichts zu tun, wenn Knoten null ist
        }
        System.out.println(prefix + currentNode.getNumber()); // aktuellen Knoten ausgeben
        printTree(currentNode.getLeft(), prefix + "L "); // linken Teilbaum ausgeben
        printTree(currentNode.getRight(), prefix + "R "); // rechten Teilbaum ausgeben
    }

}


