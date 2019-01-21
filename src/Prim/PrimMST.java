package Prim;

import java.util.ArrayList;

/**
 * Created by tino on 1/20/19.
 */
public class PrimMST {
    private Graph G;              // 图的引用
    private indexMinHeap ipq;     // 最小索引堆, 算法辅助数据结构
    private Edge[] edgeTo;        // 访问的点所对应的边, 算法辅助数据结构
    private boolean[] marked;             // 标记数组, 在算法运行过程中标记节点i是否被访问
    private ArrayList<Edge> mst;     // 最小生成树所包含的所有边
    private double mstWeight;

    public PrimMST(Graph g) {
        G = g;
        assert( g.E() >= 1 );
        mst = new ArrayList<>();
        ipq = new indexMinHeap<>(g.V());
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        visit(0);
        while(!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            assert(edgeTo[v] != null);
            mst.add(edgeTo[v]);
            visit(v);
        }

        for(Edge e : mst) {
            mstWeight += e.wt();
        }

    }

    private void visit(int v) {
        assert (!marked[v]);
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (!marked[w]) {
                if (edgeTo[w] == null) {
                    edgeTo[w] = e;
                    ipq.insert(w, e.wt());
                }
                else if (e.wt() < edgeTo[w].wt()) {
                    edgeTo[w] = e;
                    ipq.change(w, e.wt());
                }

            }
        }
    }

    public ArrayList<Edge> mstEdges() {
        return mst;
    }

    public double result() {
        return mstWeight;
    }

}
