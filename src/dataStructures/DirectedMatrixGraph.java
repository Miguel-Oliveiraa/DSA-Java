package dataStructures;

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

    public void dfsGraphTraverse(int start) {
        for (int i = 0; i < matrix.length; i++) {
            setMark(i, -1);
        }

        DFS(start);
//        for (int i = 0; i < matrix.length; i++) {
//            if (getMark(i) == -1) {
//                DFS(i);
//            }
//        }
    }

    void DFS(int i) {
//        pre visit
        System.out.println(i);
        setMark(i, 1);
        int w = first(i);
        while (w < matrix.length) {
            if (getMark(w) == -1) {
                DFS(w);
            }
            w = next(i,w);
        }
//        System.out.println(i);
//        pos visit
    }
}
