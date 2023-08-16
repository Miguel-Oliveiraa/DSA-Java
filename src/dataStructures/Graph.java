package dataStructures;

public interface Graph {
    int n();
    int e();
    int first(int v);
    int next(int v, int w);
    void setEdge(int i, int j, int wt);
    void delEdge(int i, int j);
    boolean isEdge(int i, int j);
    int weight(int i, int j);
    void setMark(int v, int val);
    int getMark(int v);
}
