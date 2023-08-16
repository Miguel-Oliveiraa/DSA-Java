package questions.ap10;

import dataStructures.UndirectedMatrixGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

//        Implemente um grafo não-dirigido e não-ponderado utilizando uma matriz de adjacências.
//
//        ENTRADA
//
//        A primeira linha da entrada contém os inteiros n (1 ≤ n ≤ 500) e q (1 ≤ q ≤ 105), a quantidade de vértices do grafo e o número de operações que devem ser realizadas sobre o grafo. Cada uma das próximas q linhas contém um comando que pode ser de três tipos:
//
//        add u v -- insira uma aresta entre os vértices u e v (0 ≤ u, v < n). Lembre que o grafo não é dirigido.
//        BSF v -- percorra o grafo em largura, iniciando a busca no vértice v (0 ≤ v < n). Dado um vértice arbitrário u, lembre de considerar os vértices alcançáveis a partir de u em ordem numérica crescente.
//        DFS v - percorra o grafo em profundidade, iniciando a busca no vértice v (0 ≤ v < n). Dado um vértice arbitrário u, lembre de considerar os vértices alcançáveis a partir de u em ordem numérica crescente.
//
//        5 8
//        add 0 1
//        add 1 3
//        add 0 3
//        add 3 4
//        add 3 2
//        add 2 4
//        BFS 0
//        DFS 3
//
//        SAÍDA
//
//        Para cada comando do tipo BFS ou DFS, imprima todos os vértices do grafo, na ordem em que foram visitados durante a travessia.
//
//        0 1 3 2 4
//        3 0 1 2 4

public class q1 {
    public static FastReader sc = new FastReader();

    public static void main(String[] args) {
//        Questão 01 AP 10
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
