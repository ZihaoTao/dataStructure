package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tino on 1/19/19.
 */
public class ShortestPath {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] order;

    public ShortestPath(Graph graph, int s) {
        assert (s < graph.V() && s >= 0);
        G = graph;
        this.s = s;
        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        order = new int[graph.V()];
        for(int i = 0; i < graph.V(); i++) {
            from[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()) {
            int v = q.remove();
            for(int i : G.adj(v)) {
                if(!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    from[i] = v;
                    order[i] = order[v] + 1;
                }
            }
        }


    }

    public boolean hasPath(int w) {
        assert (w < G.V() && w >= 0);
        return visited[w];
    }

    public Stack<Integer> path(int w) {
        assert (w < G.V() && w >= 0);
        assert (hasPath(w));
        Stack<Integer> s = new Stack<>();
        int p = w;
        while(p != -1) {
            s.push(p);
            p = from[p];
        }
        return s;
    }

    public void showPath(int w) {
        Stack<Integer> s = path(w);
        while (!s.isEmpty()) {
            System.out.print(s.pop());
            if(s.size() != 0) {
                System.out.print(" -> ");
            }
        }
    }

    // shortest length between s and w
    public int length(int w) {
        assert (w < G.V() && w >= 0);
        return order[w];
    }
}
