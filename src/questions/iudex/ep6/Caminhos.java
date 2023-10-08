package questions.iudex.ep6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Caminhos {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int c = sc.nextInt();
        for (int i = 1; i <= c; i++) {
            result.append("Caso " + (i) + "\n");
            int v = sc.nextInt();
            DirectedAdjiListGraph graph = new DirectedAdjiListGraph(v);
            int a = sc.nextInt();
            for (int j = 0; j <a; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int dist = sc.nextInt();
                graph.setEdge(x,y, dist);
            }
            int s = sc.nextInt();
            int[] dist = new int[v];
            graph.dijkstra(s, dist);
            for (int j = 0; j < v; j++) {
                if (dist[j] == 2147483647) {
                    result.append(-1 + "\n");
                } else {
                    result.append(dist[j] + "\n");
                }
            }
        }
        System.out.print(result);
    }

    static class DirectedAdjiListGraph {
        java.util.LinkedList<NumberDistancePair>[] adjiListGraph;
        int numEdge;
        int[] mark;

        public DirectedAdjiListGraph(int n) {
            this.mark = new int[n];
            this.adjiListGraph = new java.util.LinkedList[n];
            numEdge = 0;

            for (int i = 0; i < n; i++) {
                adjiListGraph[i] = new java.util.LinkedList<>();
            }
        }

        int first(int v) {
            if (adjiListGraph[v].peekFirst() != null) {
                return adjiListGraph[v].peekFirst().getNumber();
            }
            return adjiListGraph.length;
        }

        int next(int v, int w) {
            boolean foundw = false;
            for (int i = 0; i < adjiListGraph[v].size(); i++) {
                if (foundw) {
                    return adjiListGraph[v].get(i).getNumber();
                }

                if (adjiListGraph[v].get(i).getNumber() == w) {
                    foundw = true;
                }
            }
            return adjiListGraph.length;
        }

        public void setEdge(int i, int j, int wt) {
            assert (wt != 0) : "error";
            adjiListGraph[i].offerLast(new NumberDistancePair(j, wt));
            numEdge++;
        }

        void setMark(int v, int val) {
            mark[v] = val;
        }

        int getMark(int v) {
            return mark[v];
        }

        public void dijkstra(int s, int[] D) {
            int[] p = new int[adjiListGraph.length];
            for (int i = 0; i < adjiListGraph.length; i++) {
                setMark(i, -1);
                D[i] = 2147483647;
                p[i] = -1;
            }
            D[s] = 0;

            //criando comparador para heap
            Comparator<HeapStruct> customComparator = new Comparator<HeapStruct>() {
                @Override
                public int compare(HeapStruct o1, HeapStruct o2) {
                    return Integer.compare(o1.element3, o2.element3);
                }
            };
            //Heap para armazenar os caminhos
            PriorityQueue<HeapStruct> minHeap = new PriorityQueue<>(customComparator);
            minHeap.offer(new HeapStruct(s, s, 0));

            for (int i = 0; i < adjiListGraph.length; i++) {
                HeapStruct temp;
                do {
                    if (minHeap.isEmpty()) return;
                    temp = minHeap.poll();
                } while (getMark(temp.element2) != -1);

                setMark(temp.element2, 1);
                p[temp.element2] = temp.element1;
                int w = first(temp.element2);
                while (w < adjiListGraph.length) {
//                System.out.println("verificando a distancia de " + temp.element2 + " para " + w);
                    int distanceTempW = 1337;
                    for (int j = 0; j < adjiListGraph[temp.element2].size(); j++) {
                        if (adjiListGraph[temp.element2].get(j).getNumber() == w) {
                            distanceTempW = adjiListGraph[temp.element2].get(j).getDistance();
                        }
                    }
                    if (getMark(w) == -1 && D[w] > D[temp.element2] + distanceTempW) {
                        D[w] = D[temp.element2] + distanceTempW;
                        minHeap.offer(new HeapStruct(temp.element2, w, D[w]));
                    }
                    w = next(temp.element2, w);
                }
            }
        }


        class NumberDistancePair {
            private int number;
            private int distance;

            public NumberDistancePair(int number, int distance) {
                this.number = number;
                this.distance = distance;
            }

            public int getNumber() {
                return number;
            }

            public int getDistance() {
                return distance;
            }
        }

        static class HeapStruct {
            int element1;
            int element2;
            int element3;

            public HeapStruct(int element1, int element2, int element3) {
                this.element1 = element1;
                this.element2 = element2;
                this.element3 = element3;
            }
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
