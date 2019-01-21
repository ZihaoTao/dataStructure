package Prim;

import java.util.ArrayList;

/**
 * Created by tino on 1/19/19.
 */

public class Main {

    public static void main(String[] args) {

        String filename = "testG1.txt";
        int V = 8;

        DenseGraph g = new DenseGraph (V, false);
        ReadGraph readGraph = new ReadGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Prim MST:");
        PrimMST primMST = new PrimMST(g);
        ArrayList<Edge> mst = primMST.mstEdges();
        for(Edge e : mst) {
            System.out.println(e);
        }
        System.out.println("The MST weight is: " + primMST.result());

        System.out.println();
    }
}
