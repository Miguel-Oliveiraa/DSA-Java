package questions.iudex.ep5;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Arestas {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int cases = sc.nextInt();
        for (int i = 1; i < cases+1; i++) {
            result.append("Caso " + i + "\n");
            int v = sc.nextInt();
            int a = sc.nextInt();
            Graph grafo = new Graph(v);
            for (int j = 0; j < a; j++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                grafo.setEdge(num1, num2, 1);
            }

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                result.append(grafo.findShortestDistance(num1, num2) + "\n");
            }
        }
        System.out.print(result);
    }

    static public class Graph {
        int[][] matrix;
        int numEdge;
        int[] mark;

        public Graph(int n) {
            mark = new int[n];
            matrix = new int[n][n];
            numEdge = 0;
        }

        public int first(int v){
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[v][i] != 0) return i;
            }
            return matrix.length;
        }

        public int next(int v, int w) {
            for (int i = w+1; i < matrix.length; i++) {
                if (matrix[v][i] != 0) return i;
            }
            return matrix.length;
        }

        public void setEdge(int i, int j, int wt) {
            assert (wt!=0): "error";
            if (matrix[i][j] == 0) numEdge++;
            matrix[i][j] = wt;
        }


        public int findShortestDistance(int start, int target) {
            int[] distances = new int[matrix.length];
            Arrays.fill(distances, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            distances[start] = 0;

            while (!queue.isEmpty()) {
                int v = queue.poll();
                if (v == target){
                    return distances[v];
                }

                int w = first(v);
                while (w<matrix.length) {
                    if (distances[w] == -1) {
                        distances[w] = distances[v] + 1;
                        queue.offer(w);
                    }
                    w = next(v, w);
                }
            }
            return -1;
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
