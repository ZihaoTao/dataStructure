package Graph;

import java.util.TreeSet;

/**
 * Created by tino on 1/17/19.
 */
public class SparseGraph implements Graph{

    private int n;
    private int m;
    private boolean directed;
    private TreeSet<Integer>[] g;

    public SparseGraph( int n , boolean directed ){
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = (TreeSet<Integer>[])new TreeSet[n];
        for(int i = 0 ; i < n ; i ++) {
            g[i] = new TreeSet<>();
        }
    }

    @Override
    public int V(){
        return n;
    }

    @Override
    public int E(){
        return m;
    }

    @Override
    public void addEdge( int v, int w ){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        g[v].add(w);
        // avoid self edge
        if( v != w && !directed )
            g[w].add(v);
        m ++;
    }

    @Override
    public boolean hasEdge( int v , int w ){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v].contains(w);
    }

    @Override
    public void show(){
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for(int j : g[i]) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }
}
