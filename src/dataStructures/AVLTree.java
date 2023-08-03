package dataStructures;

public class AVLTree {

    public class Node {
        int key;
        int height;
        AVLTree.Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;


        // Metodo recursivo para calcular a pos do target
        public int getPos(int target) {
            Counter result = new Counter();
            recursionGetPos(root, result, target);
            return result.value;
        }

        // função recursiva
        private void recursionGetPos(Node node, Counter result, int target) {
            if (node == null || result.found) {
                return;
            }

            recursionGetPos(node.left, result, target);

            if (result.found) {
                return;
            }
            result.value += 1;
            if (node.key == target) {
                result.found = true;
                return; // O alvo foi encontrado, interrompe o percurso.
            }
            recursionGetPos(node.right, result, target);
        }

        // Classe auxiliar para armazenar o valor do contador e o indicador de encontrado.
        private static class Counter {
            int value;
            boolean found;

            Counter() {
                this.value = 0;
                this.found = false;
            }
        }

    public java.util.ArrayList<Integer> inOrderTraversal() {
        java.util.ArrayList<Integer> result = new java.util.ArrayList<>();
        inOrderTraversalHelper(root, result);
        return result;
    }

    private void inOrderTraversalHelper(Node node, java.util.ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        inOrderTraversalHelper(node.left, result);
        result.add(node.key);
        inOrderTraversalHelper(node.right, result);
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            System.out.println("duplicate key");
//                throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
}
