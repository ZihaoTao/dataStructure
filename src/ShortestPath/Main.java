package ShortestPath;

/**
 * Created by tino on 1/20/19.
 */
public class Main {
    public static void main(String[] args) {

        String filename = "testG1.txt";
        int V = 5;

        DenseGraph g = new DenseGraph(V, false);
        ReadGraph readGraph = new ReadGraph(g, filename);

        System.out.println("Test Dijkstra:\\n");
        Dijkstra dijkstra = new Dijkstra(g, 0);
        for( int i = 1 ; i < V ; i ++ ){
            if(dijkstra.hasPathTo(i)) {
                System.out.println("Shortest Path to " + i + " : " + dijkstra.shortestPathTo(i));
                dijkstra.showPath(i);
            }
            else
                System.out.println("No Path to " + i );

            System.out.println("----------");
        }


        System.out.println();

        // --------------------------------------------------------

        String filename2 = "testG2.txt";
        //String filename = "testG_negative_circle.txt";
        int V2 = 5;

        DenseGraph g2 = new DenseGraph(V2, true);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);

        System.out.println("Test Bellman-Ford:\n");

        int s = 0;
        BellmanFord bellmanFord = new BellmanFord(g2, s);
        if( bellmanFord.negativeCycle() )
            System.out.println("The graph contain negative cycle!");
        else
            for( int i = 0 ; i < V ; i ++ ){
                if(i == s)
                    continue;

                if(bellmanFord.hasPathTo(i)) {
                    System.out.println("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                }
                else
                    System.out.println("No Path to " + i );

                System.out.println("----------");
            }


    }
}
