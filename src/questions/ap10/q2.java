package questions.ap10;

import dataStructures.DirectedMatrixGraph;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Dado um grafo acíclico, dirigido e não-ponderado, encontre uma ordenação topológica para ele, utilizando o algoritmo toposort. Implemente o grafo como uma lista de adjacências.
//
//        ENTRADA
//
//        A primeira linha de entrada contém os inteiros n (1 ≤ n ≤ 500) e m (1 ≤ m ≤ 105), o número de vértices e o número de arestas do grafo. As próximas m linhas contêm, cada uma, os inteiros u e v (0 ≤ u, v < n), indicando que existe uma aresta entre os vértices u e v.
//
//        7 8
//        0 1
//        0 2
//        1 3
//        1 4
//        1 5
//        2 3
//        3 4
//        4 6
//
//        SAÍDA
//
//        Imprima uma linha com todos os vértices do grafo separados por espaço. A ordem dos vértices na saída deve corresponder a uma ordenação topológica do grafo da entrada.
//
//        0 2 1 5 3 4 6


public class q2 {

    public static FastReader sc = new FastReader();
    public static void main(String[] args) {
        //        Questão 02 AP 10
        StringBuilder result = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();
        DirectedMatrixGraph graph = new DirectedMatrixGraph(n);
        for (int i = 0; i < m; i++) {
            int graph1 = sc.nextInt();
            int graph2 = sc.nextInt();
            graph.setEdge(graph1, graph2, 1);
        }
        Stack<Integer> topography = graph.topoGraphSort();

        while (!topography.empty()) {
            result.append(topography.pop() + " ");
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
