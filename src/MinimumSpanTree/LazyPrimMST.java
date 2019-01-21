package MinimumSpanTree;


import WeightedGraph.Edge;
import WeightedGraph.WeightedGraph;

import java.util.ArrayList;

/**
 * Created by tino on 1/19/19.
 */
public class LazyPrimMST<Weight extends Number & Comparable>{

    private MinHeap<Edge<Weight>> pq;
    private WeightedGraph<Weight> graph;
    private boolean[] marked;
    ArrayList<Edge<Weight>> mst;
    Weight mstWeight;

    private void visit(int v) {
        assert(v >= 0 && v < graph.V());
        assert(!marked[v]);
        marked[v] = true;
        for( Edge<Weight> e : graph.adj(v) ) {
            if( !marked[e.other(v)] ) {
                pq.insert(e);
            }
        }

    }

    public LazyPrimMST(WeightedGraph g, MinHeap<Edge<Weight>> pq) {
        graph = g;
        marked = new boolean[g.V()];
        mst.clear();

        // lazy prim
        visit(0);
        while(!pq.isEmpty()) {
            Edge<Weight> e = pq.extractMin();
            if(marked[e.w()] != marked[e.v()]) {
                mst.add(e);
                if(!marked[e.v()]) {
                    visit(e.v());
                } else {
                    visit(e.w());
                }
            }
        }

        mstWeight = mst.remove(0).wt();
        while(!mst.isEmpty()) {

        }

    }

    public ArrayList<Edge<Weight>> mstEdges() {
        return mst;
    }

    public Weight result() {
        return mstWeight;
    }

}
