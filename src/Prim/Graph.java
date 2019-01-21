package Prim;


/**
 * Created by tino on 1/19/19.
 */
public interface Graph {
    int V();
    int E();
    void addEdge(Edge e);
    boolean hasEdge( int v , int w );
    void show();
    Iterable<Edge> adj(int v);
}
