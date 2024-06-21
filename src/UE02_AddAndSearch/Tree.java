package UE02_AddAndSearch;

public class Tree {

    //zeigt auf die Referenz Wurzelknoten
    private Node root;

    public void add(int number) {
        //Knoten erstellen
        Node newNode = new Node(number);

        //VARIANTE LOOP
        //addLoop(newNode);

        //VARIANTE REKURSION
        //Fall: Baum noch leer:
        if (root == null) {
            root = newNode;
        }
        //wenn nicht leer:
        else {
            addRecursive(root, newNode);
        }
    }

    // Add - Variante Rekursion
    private void addRecursive(Node currentNode, Node newNode) {

        //entweder so oder so, aufpassen beim schreiben!!!
        //if (currentNode.getNumber() > newNode.getNumber())
        //neuer wert kleiner:
        if (newNode.getNumber() < currentNode.getNumber()) {
            //fall: links ist schon ein Knoten
            if (currentNode.getLeft() != null) {
                //Rekursion mit linkem Knoten weiterführen
                addRecursive(currentNode.getLeft(), newNode);
            } else {
                currentNode.setLeft(newNode);
                newNode.setParent(currentNode);
            }
        }//neuer wert größer
        else {
            if (currentNode.getRight() != null) {
                //Rekursion mit rechtem Knoten weiterführen
                addRecursive(currentNode.getRight(), newNode);
            } else {
                currentNode.setRight(newNode);
                newNode.setParent(currentNode);
            }
        }
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
            //return searchNumberRecursive(root, number);
            // Variante 2: Aufruf Schleife
            return searchNumberLoop(number);
        }

        // Suche - Variante Rekursion
        private Node searchNumberRecursive (Node currentNode,int number){

            if (currentNode.getNumber() == number) {
                return currentNode;
            }

            if (number < currentNode.getNumber()) {
                return searchNumberRecursive(currentNode.getLeft(), number);
            }
            else {
                return searchNumberRecursive(currentNode.getRight(), number);
            }
        }


        // Suche - Variante Schleife
        private Node searchNumberLoop ( int number){

            Node current = root;

            while (current != null && current.getNumber() != number) {
                if (number < current.getNumber()) {
                    current = current.getLeft();

                } else {
                    current = current.getRight();
                }
            }
            return current;
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
