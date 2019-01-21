package Graph;

import java.util.Stack;

/**
 * Created by tino on 1/19/19.
 */
public class Path {
    private Graph G;
    private boolean[] visited;
    private int s; // source
    private int[] from;

    public Path(Graph g, int s) {
        assert(s >= 0 && s < g.V());
        G = g;
        visited = new boolean[g.V()];
        from = new int[g.V()];

        for(int i = 0; i < g.V(); i++) {
            if(!visited[i]) {
                from[i] = -1;
            }
        }
        this.s = s;
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        for(int i : G.adj(v)) {
            if(!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    // if there is a path between s and w
    public boolean hasPath(int w) {
        assert(w >= 0 && w < G.V());
        return visited[w];
    }

    public Stack<Integer> path(int w) {
        if (!hasPath(w)) {
            throw new IllegalArgumentException("No Path");
        }
        Stack<Integer> s = new Stack<>();
        int p = w;
        while (p != -1) {
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




}
