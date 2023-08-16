package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class UndirectedMatrixGraph implements Graph {
    int[][] matrix;
    int numEdge;
    int[] mark;

    public UndirectedMatrixGraph(int n) {
        mark = new int[n];
        matrix = new int[n][n];
        numEdge = 0;
    }

    @Override
    public int n() {
        return 0;
    }

    @Override
    public int e() {
        return 0;
    }

    @Override
    public int first(int v) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[v][i] != 0) return i;
        }
        return matrix.length;
    }

    @Override
    public int next(int v, int w) {
        for (int i = w+1; i < matrix.length; i++) {
            if (matrix[v][i] !=0) return i;
        }
        return matrix.length;
    }

    @Override
    public void setEdge(int i, int j, int wt) {
        assert (wt!=0): "error";
        if (matrix[i][j] == 0) numEdge++;
        matrix[i][j] = wt;
        matrix[j][i] = wt;
    }

    @Override
    public void delEdge(int i, int j) {
        if (matrix[i][j] != 0) numEdge--;
        matrix[i][j] = 0;
        matrix[j][i] = 0;
    }

    @Override
    public boolean isEdge(int i, int j) {
        return false;
    }

    @Override
    public int weight(int i, int j) {
        return 0;
    }

    @Override
    public void setMark(int v, int val) {
        mark[v] = val;
    }

    @Override
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
}
