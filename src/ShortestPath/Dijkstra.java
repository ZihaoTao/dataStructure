package ShortestPath;

import java.util.Stack;

/**
 * Created by tino on 1/20/19.
 */
// can only be used in Positive weighted graph
public class Dijkstra {
    private Graph G;
    private int s;
    private double[] distTo; // distTo[i] the shortest path length between s and i
    private boolean[] marked;
    private Edge[] from; // from[i]: the edge of i in the shortest path

    public Dijkstra(Graph g, int s) {
        this.G = g;
        this.s = s;
        distTo = new double[g.V()];
        from = new Edge[g.V()];
        marked = new boolean[g.V()];

        indexMinHeap<Double> ipq = new indexMinHeap<>(g.V());

        distTo[s] = 0;
        marked[s] = true;
        ipq.insert(s, distTo[s]);

        while(!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            marked[v] = true;

            // Relaxation
            for(Edge e : G.adj(v)) {
                int w = e.other(v);
                if(from[w] == null || distTo[w] > distTo[v] + e.wt()) {
                    from[w] = e;
                    distTo[w] = distTo[v] + e.wt();
                    if(ipq.contain(w)) {
                        ipq.change(w, distTo[w]);
                    } else {
                        ipq.insert(w, distTo[w]);
                    }
                }
            }
        }



    }

    public double shortestPathTo(int w) {
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public void showPath(int w) {
        Stack<Edge> stack = new Stack<>();
        Edge e = from[w];
        while(e.v() != this.s) {
            stack.push(e);
            e = from[e.v()];
        }
        stack.push(e);
        while (!stack.isEmpty()) {
            Edge temp  = stack.pop();
            System.out.print(temp.v());
            System.out.print(" -> ");
            if(stack.size() == 0) {
                System.out.print(temp.w());
            }
        }
        System.out.println();
    }


}
