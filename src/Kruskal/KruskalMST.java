package Kruskal;


import java.util.ArrayList;

/**
 * Created by tino on 1/20/19.
 */

// O(ElogE)
public class KruskalMST {
    private ArrayList<Edge> mst;
    private double mstWeight;

    public KruskalMST(Graph graph) {
        mst = new ArrayList<>();
        mstWeight = 0;

        MinHeap<Edge> pq = new MinHeap<>(graph.E());
        for(int i = 0; i < graph.V(); i++) {
            for(Edge e : graph.adj(i)) {
                if(e.v() < e.w()) {
                    pq.insert(e);
                }
            }
        }

        QuickUnion uf = new QuickUnion(graph.V());
        while(!pq.isEmpty() && mst.size() < graph.V() - 1) {
            Edge e = pq.extractMin();
            if(!uf.isConnected(e.v(), e.w())) {
                mst.add(e);
                uf.unionElements(e.v(), e.w());
            }
        }

        for(Edge e : mst) {
            mstWeight += e.wt();
        }
    }

    public ArrayList<Edge> mstEdges() {
        return mst;
    }

    public double result() {
        return mstWeight;
    }
}
