package questions.list05;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class qb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numVertices  = scanner.nextInt();
        int numEdges  = scanner.nextInt();

        Graph graph  = new Graph(numVertices);

        for (int edge = 0; edge < numEdges; edge++) {
            int fromVertex  = scanner.nextInt();
            int toVertex  = scanner.nextInt();

            graph.add(fromVertex, toVertex );
        }

        graph.toposort();
    }

    static class Graph {
        private List<List<Integer>> list;
        private int size;
        private List<Integer> grau;

        public Graph(int size) {
            this.size = size;
            list = new ArrayList<>(size + 1);
            for (int i = 0; i <= size; i++) {
                list.add(new ArrayList<>());
            }
            grau = new ArrayList<>(Collections.nCopies(size + 1, 0));
        }

        public void add(int i, int j) {
            list.get(i).add(j);
            grau.set(j, grau.get(j) + 1);
        }

        public void toposort() {
            List<Integer> ordem = new ArrayList<>();
            PriorityQueue<Integer> q = new PriorityQueue<>();

            for (int i = 1; i <= size; i++) {
                if (grau.get(i) == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int c = q.poll();
                ordem.add(c);

                for (int i : list.get(c)) {
                    grau.set(i, grau.get(i) - 1);
                    if (grau.get(i) == 0) {
                        q.add(i);
                    }
                }
            }

            if (ordem.size() == size) {
                for (int i = 0; i < size; i++) {
                    System.out.print(ordem.get(i) + " ");
                }
            } else {
                System.out.print("Sandro fails.");
            }
            System.out.println();
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
