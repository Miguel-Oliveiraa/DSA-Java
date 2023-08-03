import dataStructures.AVLTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//list04 Q1
public class Main {

    public static FastReader sc = new FastReader();

    public static void main(String[] args) {
//        StringBuilder result = new StringBuilder(); // String para resultado final
        AVLTree tree = new AVLTree();
        for (int i = 0; i < 1200; i++) {
            int input = sc.nextInt();
            tree.insert(input);
        }
        int resultOrdenado = tree.getPos(99892);
        System.out.println(resultOrdenado);
//        System.out.print(result); // Print final
    }

//    public static class AVLTree {
//
//        public class Node {
//            int key;
//            int height;
//            Node left;
//            Node right;
//
//            Node(int key) {
//                this.key = key;
//            }
//        }
//
//        private Node root;
//
//
////        // Metodo recursivo para calcular a pos do target
////        public int getPos(int target) {
////            Counter result = new Counter();
////            recursionGetPos(root, result, target);
////            return result.value;
////        }
////
////        // função recursiva
////        private void recursionGetPos(Node node, Counter result, int target) {
////            if (node == null || result.found) {
////                return;
////            }
////
////            recursionGetPos(node.left, result, target);
////
////            if (result.found) {
////                return;
////            }
////            result.value += 1;
////            if (node.key == target) {
////                result.found = true;
////                return; // O alvo foi encontrado, interrompe o percurso.
////            }
////            recursionGetPos(node.right, result, target);
////        }
////
////        // Classe auxiliar para armazenar o valor do contador e o indicador de encontrado.
////        private static class Counter {
////            int value;
////            boolean found;
////
////            Counter() {
////                this.value = 0;
////                this.found = false;
////            }
////        }
//
//        // find
//        public Node find(int key) {
//            Node current = root;
//            while (current != null) {
//                if (current.key == key) {
//                    break;
//                }
//                current = current.key < key ? current.right : current.left;
//            }
//            return current;
//        }
//
//
//        // insert
//        public void insert(int key) {
//            root = insert(root, key);
//        }
//
//
//        public Node getRoot() {
//            return root;
//        }
//
//        public int height() {
//            return root == null ? -1 : root.height;
//        }
//
//        private Node insert(Node node, int key) {
//            if (node == null) {
//                return new Node(key);
//            } else if (node.key > key) {
//                node.left = insert(node.left, key);
//            } else if (node.key < key) {
//                node.right = insert(node.right, key);
//            } else {
//                throw new RuntimeException("duplicate Key!");
//            }
//            return rebalance(node, key);
//        }
//
//
//        private Node rebalance(Node z, int key) {
//            updateHeight(z);
//            int balance = getBalance(z);
//            if (balance<-1 && key >= z.right.key) {
//                z = rotateLeft(z);
//            }
//            if (balance > 1 && key < z.left.key) {
//                z = rotateRight(z);
//            }
//            if (balance>1 && key >= z.left.key) {
//                z.left = rotateLeft(z.left);
//                z = rotateRight(z);
//            }
//            if (balance<-1 && key < z.right.key) {
//                z.right = rotateRight(z.right);
//                z = rotateLeft(z);
//            }
//            return z;
//        }
//
//        private Node rotateRight(Node rt) {
//            Node l = rt.left;
//            Node lr = l.right;
//            l.right = rt;
//            rt.left = lr;
//            updateHeight(rt);
//            updateHeight(l);
//            return l;
//        }
//
//        private Node rotateLeft(Node rt) {
//            Node r = rt.right;
//            Node rl = r.left;
//            r.left = rt;
//            rt.right = rl;
//            updateHeight(rt);
//            updateHeight(r);
//            return r;
//        }
//
//        private void updateHeight(Node n) {
//            n.height = 1 + Math.max(height(n.left), height(n.right));
//        }
//
//        private int height(Node n) {
//            return n == null ? -1 : n.height;
//        }
//
//        public int getBalance(Node n) {
//            return (n == null) ? 0 : height(n.left) - height(n.right);
//        }
//    }

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
