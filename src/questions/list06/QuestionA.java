package questions.list06;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QuestionA {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        StringBuilder result = new StringBuilder();
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            result.append("Case #" + (i+1) + ": ");
            int n = sc.nextInt();
            UndirectedMatrixGraph grafo = new UndirectedMatrixGraph(n);
            int m = sc.nextInt();
            int t = sc.nextInt();
            int s = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int distance = sc.nextInt();
                grafo.setEdge(x, y, distance);
            }
            int[] D = new int[n];
            grafo.dijkstras(t, D);
            if (D[s] == 13337) {
                result.append("unreachable\n");
            } else {
                result.append(D[s] + "\n");
            }
        }
        System.out.print(result);
    }

    static class UndirectedMatrixGraph {
        int[][] matrix;
        int numEdge;
        int[] mark;

        public UndirectedMatrixGraph(int n) {
            mark = new int[n];
            matrix = new int[n][n];
            numEdge = 0;
        }

        public int n() {
            return 0;
        }

        public int e() {
            return 0;
        }

        public int first(int v) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[v][i] != 0) return i;
            }
            return matrix.length;
        }

        public int next(int v, int w) {
            for (int i = w+1; i < matrix.length; i++) {
                if (matrix[v][i] !=0) return i;
            }
            return matrix.length;
        }

        public void setEdge(int i, int j, int wt) {
            assert (wt!=0): "error";
            if (matrix[i][j] == 0) numEdge++;
            matrix[i][j] = wt;
            matrix[j][i] = wt;
        }

        public void delEdge(int i, int j) {
            if (matrix[i][j] != 0) numEdge--;
            matrix[i][j] = 0;
            matrix[j][i] = 0;
        }

        public boolean isEdge(int i, int j) {
            return false;
        }

        public int weight(int i, int j) {
            return 0;
        }

        public void setMark(int v, int val) {
            mark[v] = val;
        }

        public int getMark(int v) {
            return mark[v];
        }


        public void dijkstras(int s, int[] D) {
            //Parents
            int[] p = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                setMark(i, -1);
                D[i] = 13337;
                p[i] = -1;
            }
            D[s] = 0;

            //criando comparador para heap
            Comparator<HeapStruct> customComparator = new Comparator<HeapStruct>() {
                @Override
                public int compare(HeapStruct s1, HeapStruct s2) {
                    return Integer.compare(s1.element3, s2.element3);
                }
            };
            // heap para armazenar os caminhos
            PriorityQueue<HeapStruct> minHeap = new PriorityQueue<>(customComparator);
            minHeap.offer(new HeapStruct(s,s,0));

            for (int i = 0; i < matrix.length; i++) {
                HeapStruct temp;
                do {
                    if (minHeap.isEmpty()) return;
                    temp = minHeap.poll();
                } while (getMark(temp.element2) != -1);

                setMark(temp.element2, 1);
                int w = first(temp.element2);
                while (w<matrix.length) {
                    if (getMark(w) == -1 && D[w] > D[temp.element2] + matrix[temp.element2][w]) {
                        D[w] = D[temp.element2] + matrix[temp.element2][w];
                        minHeap.offer(new HeapStruct(temp.element2, w, D[w]));
                    }
                    w = next(temp.element2, w);
                }
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


//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader()
//        {
//            br = new BufferedReader(
//                    new InputStreamReader(System.in));
//        }
//
//        String next()
//        {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() { return Integer.parseInt(next()); }
//
//        long nextLong() { return Long.parseLong(next()); }
//
//        double nextDouble()
//        {
//            return Double.parseDouble(next());
//        }
//
//        String nextLine()
//        {
//            String str = "";
//            try {
//                if(st.hasMoreTokens()){
//                    str = st.nextToken("\n");
//                }
//                else{
//                    str = br.readLine();
//                }
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
}
