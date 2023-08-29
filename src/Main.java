import dataStructures.DirectedMatrixGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//list04 Q1
public class Main {

    public static FastReader sc = new FastReader();

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int cases = sc.nextInt();
        for (int i = 1; i < cases+1; i++) {
            result.append("Caso " + i + "\n");
            int v = sc.nextInt();
            int a = sc.nextInt();
            DirectedMatrixGraph grafo = new DirectedMatrixGraph(v);
            for (int j = 0; j < a; j++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                grafo.setEdge(num1, num2, 1);
            }

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int vertice = sc.nextInt();
                int[] distance = new int[v];
                result.append("Distancias vertice " + vertice + ":\n");
                grafo.dijkstras(vertice, distance);
                for (int k = 0; k < v; k++) {
                    result.append(distance[k] + " ");
                }
                result.append("\n");
            }
        }
        System.out.print(result);
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
