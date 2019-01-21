package Kruskal;

import java.util.ArrayList;

/**
 * Created by tino on 1/20/19.
 */
public class Main {

    public static void main(String[] args) {

        String filename = "testG1.txt";
        int V = 8;

        DenseGraph g = new DenseGraph (V, false);
        ReadGraph readGraph = new ReadGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Kruskal MST:");
        KruskalMST kruskalMST = new KruskalMST(g);
        ArrayList<Edge> mst = kruskalMST.mstEdges();
        for(Edge e : mst) {
            System.out.println(e);
        }
        System.out.println("The MST weight is: " + kruskalMST.result());

        System.out.println();
    }
}
