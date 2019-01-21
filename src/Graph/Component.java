package Graph;

/**
 * Created by tino on 1/18/19.
 */
public class Component {
    private Graph G;
    private boolean[] visited;
    private int[] id;
    private int count;

    public Component(Graph g) {
        G = g;
        visited = new boolean[g.V()];
        id = new int[g.V()];

        for(int i = 0; i < g.V(); i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = count;
        for(int i : G.adj(v)) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int v, int w) {
        assert (v < G.V() && v >= 0);
        assert (w < G.V() && w >= 0);
        return id[v] == id[w];
    }
}
