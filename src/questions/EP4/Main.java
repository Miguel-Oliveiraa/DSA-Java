package questions.EP4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;
public class Main {
    private static FastReader sc = new FastReader();
    public static void main(String[] args) {
        int n = sc.nextInt();
        AVLTreeTraining tree = new AVLTreeTraining();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String query = sc.next();
            if (Objects.equals("insert", query)) {
                int value = sc.nextInt();
                tree.insert(value);
            } else if (Objects.equals("pre", query)) {
                StringBuilder queryResult = tree.preOrder();
                queryResult.deleteCharAt(queryResult.length() - 1);
                result.append(queryResult + "\n");
            } else if (Objects.equals("in", query)) {
                StringBuilder queryResult = tree.inOrder();
                queryResult.deleteCharAt(queryResult.length() - 1);
                result.append(queryResult + "\n");
            } else {
                StringBuilder queryResult = tree.posOrder();
                queryResult.deleteCharAt(queryResult.length() - 1);
                result.append(queryResult + "\n");
            }
        }
        System.out.print(result);
//        AVLTreeTraining tree = new AVLTreeTraining();
//        for (int i = 0; i < 1200; i++) {
//            int n = sc.nextInt();
//            tree.insert(n);
//        }
//        System.out.println(tree.inOrder());
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
