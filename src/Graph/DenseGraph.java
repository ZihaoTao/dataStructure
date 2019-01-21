package Graph;

import java.util.ArrayList;

/**
 * Created by tino on 1/17/19.
 */


public class DenseGraph implements Graph{

    private int n;
    private int m;
    private boolean directed;
    private boolean[][] g;

    public DenseGraph( int n , boolean directed ){
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // default value: false
        g = new boolean[n][n];
    }

    @Override
    public int V(){ return n;}

    @Override
    public int E(){ return m;}

    @Override
    public void addEdge( int v , int w ){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        if( hasEdge( v , w ) )
            return;
        g[v][w] = true;
        if( !directed ) {
            g[w][v] = true;
        }
        m ++;
    }

    @Override
    public boolean hasEdge( int v , int w ){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v][w];
    }

    @Override
    public void show(){
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ) {
                System.out.print(g[i][j] ? 1 + "\t" : 0 + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        ArrayList<Integer> adjV = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++ )
            if( g[v][i] )
                adjV.add(i);
        return adjV;
    }
}