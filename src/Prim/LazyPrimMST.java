package Prim;

import java.util.ArrayList;

/**
 * Created by tino on 1/19/19.
 */
public class LazyPrimMST {
    private MinHeap<Edge> pq;
    private Graph graph;
    private boolean[] marked;
    private ArrayList<Edge> mst;
    private double mstWeight;

    private void visit(int v) {
        assert(v >= 0 && v < graph.V());
        assert(!marked[v]);
        marked[v] = true;
        for( Edge e : graph.adj(v) ) {
            if( !marked[e.other(v)] ) {
                pq.insert(e);
            }
        }

    }

    //O(ElogE)

    public LazyPrimMST(Graph g) {
        graph = g;
        marked = new boolean[g.V()];
        pq = new MinHeap<>(g.E());
        mst = new ArrayList<>();

        // lazy prim
        visit(0);

        while(!pq.isEmpty()) {
            Edge e = pq.extractMin();
            if(marked[e.w()] != marked[e.v()]) {
                mst.add(e);
                if(!marked[e.v()]) {
                    visit(e.v());
                } else {
                    visit(e.w());
                }
            }
        }

        for(int i = 0; i < mst.size(); i++) {
            mstWeight += mst.get(i).wt();
        }


    }

    public ArrayList<Edge> mstEdges() {
        return mst;
    }

    public double result() { return mstWeight; }
}
