package questions.vjudge.lista3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TraversingTree {

    static private FastReader scanner = new FastReader();

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int n = scanner.nextInt();

        BST tree = new BST();

        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            tree.insert(key);
        }

        System.out.print("Pre order :");
        tree.preorder(tree.getRoot());
        System.out.println();
        System.out.print("In order  :");
        tree.inorder(tree.getRoot());
        System.out.println();
        System.out.print("Post order:");
        tree.posorder(tree.getRoot());
    }

    public static class Node {
        public int key;
        public Node right;
        public Node left;

        public Node(int key) {
            this.key = key;
            right = left = null;
        }
    }

    public static class BST {
        private Node root;
        private int size;

        private Node inserthelp(Node help, int key) {
            if (help == null) {
                return new Node(key);
            }

            if (help.key > key) {
                help.left = inserthelp(help.left, key);
            } else {
                help.right = inserthelp(help.right, key);
            }

            return help;
        }

        public BST() {
            root = null;
            size = 0;
        }

        public void insert(int key) {
            root = inserthelp(root, key);
            size++;
        }

        public Node getRoot() {
            return root;
        }

        public void preorder(Node help) {
            if (help == null) {
                return;
            }
            System.out.print(" " + help.key);
            preorder(help.left);
            preorder(help.right);
        }

        public void inorder(Node help) {
            if (help == null) {
                return;
            }
            inorder(help.left);
            System.out.print(" " + help.key);
            inorder(help.right);
        }

        public void posorder(Node help) {
            if (help == null) {
                return;
            }
            posorder(help.left);
            posorder(help.right);
            System.out.print(" " + help.key);
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
