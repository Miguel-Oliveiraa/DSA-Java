import dataStructures.DirectedMatrixGraph;
import dataStructures.UndirectedMatrixGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

//list04 Q1
public class Main {

    public static FastReader sc = new FastReader();

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        int n = sc.nextInt();
        int v = sc.nextInt();
        UndirectedMatrixGraph graph = new UndirectedMatrixGraph(n);
        for (int i = 0; i < v; i++) {
            String op = sc.next();
            if (Objects.equals(op, "add")){
                int graph1 = sc.nextInt();
                int graph2 = sc.nextInt();
                graph.setEdge(graph1, graph2, 1);
            } else if(Objects.equals(op, "BFS")) {
                int start = sc.nextInt();
                result.append(graph.bfsGraphTraverse(start) + "\n");
            } else if(Objects.equals(op, "DFS")) {
                int start = sc.nextInt();
                result.append(graph.dfsGraphTraverse(start) + "\n");
            }
        }
        System.out.println(result);
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
