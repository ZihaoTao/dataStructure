package ShortestPath;

import java.util.Stack;

/**
 * Created by tino on 1/20/19.
 */

// negative weighted graph must be directed.
public class BellmanFord {

    private Graph G;
    private int s;
    private double[] distTo;
    private Edge[] from;
    private boolean hasNegativeCycle;

    public BellmanFord(Graph graph, int s) {
        this.G = graph;
        this.s = s;
        distTo = new double[graph.V()];
        from = new Edge[graph.V()];

        distTo[s] = 0;

        //Most steps to get the shortest path:
        for (int pass = 1; pass < G.V(); pass++) {
            // Relaxation
            for(int i = 0; i < G.V(); i++) {
                for(Edge e : G.adj(i)) {
                    if((from[e.w()] == null || distTo[e.v()] + e.wt() < distTo[e.w()])){
                        distTo[e.w()] = distTo[e.v()] + e.wt();
                        from[e.w()] = e;
                    }
                }
            }
        }

        hasNegativeCycle = detectNegativeCircle();

    }

    // do relaxation one more time, if it works, negative circle exists.
    public boolean detectNegativeCircle() {
        for(int i = 0; i < G.V(); i++) {
            for(Edge e : G.adj(i)) {
                if( from[e.w()] == null && distTo[e.v()] + e.wt() < distTo[e.w()])
                    return true;
            }
        }
        return false;
    }

    public boolean negativeCycle() {
        return hasNegativeCycle;
    }

    public double shortestPathTo(int w) {
        assert (w >= 0 && w < G.V());
        assert (!hasNegativeCycle);
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        return from[w] != null;
    }

    public void showPath(int w) {
        assert !hasNegativeCycle ;
        assert hasPathTo(w) ;

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
