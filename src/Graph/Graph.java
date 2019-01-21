package Graph;

/**
 * Created by tino on 1/17/19.
 */
public interface Graph{
    int V();
    int E();
    void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    Iterable<Integer> adj(int v);
}
