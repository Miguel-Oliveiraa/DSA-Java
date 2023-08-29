package dataStructures;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DirectedMatrixGraph implements Graph {
    int[][] matrix;
    int numEdge;
    int[] mark;

    public DirectedMatrixGraph(int n) {
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
    }

    @Override
    public void delEdge(int i, int j) {
        if (matrix[i][j] != 0) numEdge--;
        matrix[i][j] = 0;
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

    //dijkstra's algorithm
    public void dijkstras(int s, int[] D) {
        //Parents
        int[] p = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            setMark(i, -1);
            D[i] = 1337;
            p[i] = -1;
        }
        D[s] = 0;

        //criando comparador para heap
        Comparator<HeapStruct> customComparator = new Comparator<HeapStruct>() {
            @Override
            public int compare(HeapStruct s1, HeapStruct s2) {
                // Compare based on the first element
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
