package questions.treinamento;

import dataStructures.DirectedAdjiListGraph;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int v = sc.nextInt();
            DirectedAdjiListGraph grafo = new DirectedAdjiListGraph(v);
            int c = sc.nextInt();
            for (int j = 0; j < c; j++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                int distance = sc.nextInt();
                grafo.setEdge(n1, n2, distance);
            }
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int vertice = sc.nextInt();
                int[] distance = new int[v];
                grafo.dijkstra(vertice, distance);
                for (int k = 0; k < v; k++) {
                    if (distance[k] == 1337) {
                        System.out.print(-1 + " ");
                    } else {
                        System.out.print(distance[k] + " ");
                    }
                }
                System.out.println("");
            }
        }
    }
}
