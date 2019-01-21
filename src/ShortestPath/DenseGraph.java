package ShortestPath;

import java.util.ArrayList;

/**
 * Created by tino on 1/17/19.
 */


public class DenseGraph implements Graph {

    private int n;
    private int m;
    private boolean directed;
    private Edge[][] g;


    public DenseGraph(int n , boolean directed ){
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // default value: false
        g = new Edge[n][n];
    }

    @Override
    public int V(){ return n;}

    @Override
    public int E(){ return m;}

    @Override
    public void addEdge(Edge e){

        assert e.v() >= 0 && e.v() < n ;
        assert e.w() >= 0 && e.w() < n ;

        if( hasEdge( e.v() , e.w() ) )
            return;

        g[e.v()][e.w()] = new Edge(e);
        if( e.v() != e.w() && !directed )
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.wt());

        m ++;
    }

    @Override
    public boolean hasEdge( int v , int w ){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v][w] != null;
    }

    @Override
    public void show(){
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ ) {
                System.out.print(g[i][j] == null ? "NULL + \t" : g[i][j].wt() + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge> adj(int v) {
        assert v >= 0 && v < n;
        ArrayList<Edge> adjV = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++ )
            if( g[v][i] != null )
                adjV.add(g[v][i]);
        return adjV;
    }
}