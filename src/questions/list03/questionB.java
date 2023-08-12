package questions.list03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;;
import java.util.StringTokenizer;

public class questionB {
    private static FastReader sc = new FastReader();

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int n = sc.nextInt();
        AVLTree tree = new AVLTree();
        for (int i = 0; i < n; i++) {
            tree.insert(sc.nextInt());
        }
        StringBuilder queryResult = tree.preOrder();
        queryResult.deleteCharAt(queryResult.length() - 1);
        result.append("Pre order : " + queryResult + "\n");

        queryResult = tree.inOrder();
        queryResult.deleteCharAt(queryResult.length() - 1);
        result.append("In order  : " + queryResult + "\n");

        queryResult = tree.posOrder();
        queryResult.deleteCharAt(queryResult.length() - 1);
        result.append("Post order: " + queryResult + "\n");
        System.out.print(result);

    }

    public static class AVLTree {

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


        // Classe auxiliar para armazenar o valor do contador e o indicador de encontrado.
        private static class Counter {
            int value;
            boolean found;

            Counter() {
                this.value = 0;
                this.found = false;
            }
        }


        //in order
        public StringBuilder inOrder() {
            StringBuilder result = new StringBuilder();
            inOrderHelper(root, result);
            return result;
        }

        private void inOrderHelper(Node node, StringBuilder result) {
            if (node == null) {
                return;
            }

            inOrderHelper(node.left, result);
            result.append(node.key + " ");
            inOrderHelper(node.right, result);
        }


        //pre order
        public StringBuilder preOrder() {
            StringBuilder result = new StringBuilder();
            preOrderHelper(root, result);
            return result;
        }

        private void preOrderHelper(Node node, StringBuilder result) {
            if (node == null) {
                return;
            }

            result.append(node.key + " ");
            preOrderHelper(node.left, result);
            preOrderHelper(node.right, result);
        }

        //pos order
        public StringBuilder posOrder() {
            StringBuilder result = new StringBuilder();
            posOrderHelper(root, result);
            return result;
        }

        private void posOrderHelper(Node node, StringBuilder result) {
//    private void inOrderHelper(Node node) {
            if (node == null) {
                return;
            }

            posOrderHelper(node.left, result);
//        System.out.println(node.key);
//        result.add(node.key);
            posOrderHelper(node.right, result);
            result.append(node.key + " ");
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



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
