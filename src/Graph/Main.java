package Graph;

/**
 * Created by tino on 1/17/19.
 */
public class Main {
    public static void main(String[] args) {
        String filename = "testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        System.out.println("test G1 in Sparse Graph:");
        g1.show();
        Component component = new Component(g1);
        System.out.println("Count of connected components:\t" + component.count());

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename);
        System.out.println("test G1 in Sparse Graph:");
        g2.show();

        SparseGraph g3 = new SparseGraph(13, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        Path path = new Path(g3, 0);
        g3.show();
        System.out.println("DFS:");
        path.showPath(6);

        SparseGraph g4 = new SparseGraph(13, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        ShortestPath bfs = new ShortestPath(g4, 0);
        g4.show();
        System.out.println("BFS:");
        System.out.println(bfs.length(6));
        bfs.showPath(6);
    }
}
