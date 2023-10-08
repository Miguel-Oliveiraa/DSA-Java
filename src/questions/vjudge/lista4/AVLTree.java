package questions.vjudge.lista4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.max;

public class AVLTree {

    static FastReader scanner = new FastReader();

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int n = scanner.nextInt();
        BST tree = create_BST();

        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            int value = scanner.nextInt();

            if (op == 1) {
                insert(tree, value);
            } else if (op == 2) {
                int num = findIndex(tree, value);
                if (num == 0) {
                    result.append("Data tidak ada\n");
                } else {
                    result.append(num + "\n");
                }
            }
        }
        System.out.print(result);
    }
    static class BSTNode {
        int key;
        int height;
        int childrenLeft;
        int childrenRight;
        BSTNode left;
        BSTNode right;

        BSTNode(int k) {
            key = k;
            left = null;
            right = null;
            childrenLeft = 0;
            childrenRight = 0;
            height = 0;
        }
    }

    static class BST {
        BSTNode root;
        int nodecount;

        BST() {
            root = null;
            nodecount = 0;
        }
    }

    static BST create_BST() {
        return new BST();
    }

    static BSTNode create_bstNode(int k) {
        return new BSTNode(k);
    }

    static int findIndex(BST tree, int k) {
        int flag = find(tree, k);
        int i;

        if (flag == -1) return 0;

        i = findIndexHelp(tree.root, k);

        return i;
    }

    static int findIndexHelp(BSTNode rt, int k) {
        if (rt.key == k) return rt.childrenLeft + 1;
        else if (rt.key < k) return rt.childrenLeft + 1 + findIndexHelp(rt.right, k);
        else return findIndexHelp(rt.left, k);
    }

    static int find(BST bst, int k) {
        return findhelp(bst.root, k);
    }

    static int findhelp(BSTNode rt, int k) {
        if (rt == null) return -1;
        if (rt.key > k) {
            return findhelp(rt.left, k);
        } else if (rt.key == k) {
            return rt.key;
        } else {
            return findhelp(rt.right, k);
        }
    }

    static void insert(BST bst, int k) {
        bst.root = inserthelp(bst.root, k);
        bst.nodecount++;
    }

    static BSTNode inserthelp(BSTNode rt, int k) {
        if (rt == null) return create_bstNode(k);
        if (rt.key > k) {
            rt.childrenLeft++;
            rt.left = inserthelp(rt.left, k);
        } else {
            rt.childrenRight++;
            rt.right = inserthelp(rt.right, k);
        }

        rt.height = 1 + max(h(rt.left), h(rt.right));
        int balance = getBalance(rt);

        if (balance < -1 && k >= rt.right.key) return leftRotate(rt);
        if (balance > 1 && k < rt.left.key) return rightRotate(rt);
        if (balance > 1 && k >= rt.left.key) {
            rt.left = leftRotate(rt.left);
            return rightRotate(rt);
        }
        if (balance < -1 && k < rt.right.key) {
            rt.right = rightRotate(rt.right);
            return leftRotate(rt);
        }
        return rt;
    }

    static int getBalance(BSTNode rt) {
        if (rt == null) return 0;
        return (h(rt.left) - h(rt.right));
    }

    static int h(BSTNode rt) {
        if (rt == null) return -1;
        return rt.height;
    }

    static BSTNode rightRotate(BSTNode rt) {
        BSTNode l = rt.left;
        BSTNode lr = l.right;

        int lRightC = l.childrenRight;
        int rtRgithC = rt.childrenRight;

        l.childrenRight = lRightC + rtRgithC + 1;
        rt.childrenLeft = lRightC;

        l.right = rt;
        rt.left = lr;
        rt.height = max(h(rt.left), h(rt.right)) + 1;
        l.height = max(h(l.left), h(l.right)) + 1;

        return l;
    }

    static BSTNode leftRotate(BSTNode rt) {
        BSTNode r = rt.right;
        BSTNode rl = r.left;

        int rLeftC = r.childrenLeft;
        int rtLeftC = rt.childrenLeft;

        r.childrenLeft = rLeftC + rtLeftC + 1;
        rt.childrenRight = rLeftC;

        r.left = rt;
        rt.right = rl;
        rt.height = max(h(rt.left), h(rt.right)) + 1;
        r.height = max(h(r.left), h(r.right)) + 1;

        return r;
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
