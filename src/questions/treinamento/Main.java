package questions.treinamento;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int size = sc.nextInt();
            int n = sc.nextInt();
            DirectedMatrixGraph graph = new DirectedMatrixGraph(size);
            for (int j = 0; j < n; j++) {
                int vertice1 = sc.nextInt();
                int vertice2 = sc.nextInt();
                graph.setEdge(vertice1, vertice2, 1);
            }
            int queries = sc.nextInt();
            for (int j = 0; j < queries; j++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                result.append(graph.findShortestDistances(n1, n2) + "\n");
            }
        }
        System.out.println(result);
    }

    static public class DirectedMatrixGraph {
        int[][] matrix;
        int numEdge;
        int[] mark;

        public DirectedMatrixGraph(int n) {
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
        }

        public void delEdge(int i, int j) {
            if (matrix[i][j] != 0) numEdge--;
            matrix[i][j] = 0;
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

        public StringBuilder dfsGraphTraverse(int start) {
            for (int i = 0; i < matrix.length; i++) {
                setMark(i, -1);
            }

            StringBuilder result = new StringBuilder();
            DFS(start, result);
            return result;
//        Gustavo faz assim no slide
//        for (int i = 0; i < matrix.length; i++) {
//            if (getMark(i) == -1) {
//                DFS(i);
//            }
//        }
        }

        void DFS(int i, StringBuilder result) {
//        pre visit
//        System.out.println(i);
            result.append(i + " ");
            setMark(i, 1);
            int w = first(i);
            while (w < matrix.length) {
                if (getMark(w) == -1) {
                    DFS(w, result);
                }
                w = next(i,w);
            }
//        System.out.println(i);
//        pos visit
        }

        public int findShortestDistances(int start, int target) {
            int[] distances = new int[matrix.length];
            Arrays.fill(distances, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            distances[start] = 0;

            while (!queue.isEmpty()) {
                int v = queue.poll();
                if (v==target) {
                    return distances[v];
                }
                int w = first(v);
                while (w < matrix.length) {
                    if (distances[w] == -1) {
                        distances[w] = distances[v] + 1;
                        queue.offer(w);
                    }
                    w = next(v, w);
                }
            }

            return -1;
        }

        public StringBuilder bfsGraphTraverse(int start) {
            for (int i = 0; i < matrix.length; i++) {
                setMark(i, -1);
            }
            StringBuilder result = new StringBuilder();
            BFS(start, result);
            return result;
        }

        void BFS(int start, StringBuilder result) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            setMark(start, 1);
            while (queue.size() > 0) {
                int v = queue.poll();
                //Previsit
//            System.out.println(v);
                result.append(v + " ");
                int w = first(v);
                while (w < matrix.length) {
                    if (getMark(w) == -1) {
                        setMark(w, 1);
                        queue.offer(w);
                    }
                    w = next(v,w);
                }
                //posvisit
            }
        }

        public Stack<Integer> topoGraphSort() {
            for (int i = 0; i < matrix.length; i++) {
                setMark(i, -1);
            }

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < matrix.length; i++) {
                if (getMark(i) == -1) {
                    toposort(i, stack);
                }
            }
            return stack;
        }

        void toposort(int v, Stack<Integer> s) {
            setMark(v, 1);
            int w = first(v);
            while (w < matrix.length) {
                if (getMark(w) == -1) {
                    toposort(w, s);
                }
                w = next(v,w);
            }
            s.push(v);
        }
    }
}