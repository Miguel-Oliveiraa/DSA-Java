package dataStructures;

public class AVLTree {

    public class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;


    // find
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


    // insert
    public void insert(int key) {
        root = insert(root, key);
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
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node, key);
    }


    private Node rebalance(Node z, int key) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance<-1 && key >= z.right.key) {
            z = rotateLeft(z);
        }
        if (balance > 1 && key < z.left.key) {
            z = rotateRight(z);
        }
        if (balance>1 && key >= z.left.key) {
            z.left = rotateLeft(z.left);
            z = rotateRight(z);
        }
        if (balance<-1 && key < z.right.key) {
            z.right = rotateRight(z.right);
            z = rotateLeft(z);
        }
        return z;
    }

    private Node rotateRight(Node rt) {
        Node l = rt.left;
        Node lr = l.right;
        l.right = rt;
        rt.left = lr;
        updateHeight(rt);
        updateHeight(l);
        return l;
    }

    private Node rotateLeft(Node rt) {
        Node r = rt.right;
        Node rl = r.left;
        r.left = rt;
        rt.right = rl;
        updateHeight(rt);
        updateHeight(r);
        return r;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }
}
