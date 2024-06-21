package UE02_AddAndSearch;

public class Tree {

    //zeigt auf die Referenz Wurzelknoten
    private Node root;

    public void add(int number) {
        //Knoten erstellen
        Node newNode = new Node(number);

        //addLoop(root, newNode);

    }

    // Add - Variante Rekursion
    private void addRecursive(Node currentNode, Node newNode) {
        // TODO
    }

    // Add - Variante Loop
    private void addLoop(Node newNode) {
        // Fall: Baum ist leer:
        if (root == null) {
            root = newNode;
        }
        //wenn nicht leer ist (mind 1 Rootnode):
        else {
            //Hilfsvariable
            Node current = root;
            while (true){
                //Neuer Wert ist kleiner:
                if (newNode.getNumber() < current.getNumber()) {

                    //Wenn links schon ein Knoten ist, dann weiterhüpfen
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                        //Wenn links kein Knoten ist, dann dort anhängen
                    } else {
                        current.setLeft(newNode);
                        newNode.setParent(current); //parent setzen
                        break;
                    }
                }
                    //Neuer Wert ist größer
                else{
                        if (current.getRight() != null) {
                            current = current.getRight();
                        } else {
                            current.setRight(newNode);
                            newNode.setParent(newNode); // parent setzen
                            newNode.setParent(newNode); // parent setzen
                            break;
                        }
                    }
                }
            }
        }

        public Node searchNumber ( int number){
            System.out.print("SearchNumber - ");

            // TODO: Entweder Variante 1 oder 2 einkommentieren
            // Variante 1: Aufruf Rekursiv
            return searchNumberRecursive(root, number);
            // Variante 2: Aufruf Schleife
            //return searchNumberLoop(number);
        }

        // Suche - Variante Rekursion
        private Node searchNumberRecursive (Node currentNode,int number){
            // TODO
            return null;
        }

        // Suche - Variante Schleife
        private Node searchNumberLoop ( int number){
            // TODO
            return null;
        }

        /**
         * Funktion zur Ausgabe des gesamten Baums.
         */
        public void printTree () {
            printTree(root, "");
        }

        /**
         * Funktion zur Ausgabe des Baums unterhalb eines Knotens
         *
         * @param currentNode Knoten, dessen Teilbaum ausgegeben werden soll
         * @param prefix      Zur Einr�ckung
         */
        public void printTree (Node currentNode, String prefix){
            if (currentNode == null) {
                return;
            }
            System.out.println(prefix + currentNode.getNumber());
            printTree(currentNode.getLeft(), prefix + "L ");
            printTree(currentNode.getRight(), prefix + "R ");
        }


    }
