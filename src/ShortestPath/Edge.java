package ShortestPath;

/**
 * Created by tino on 1/19/19.
 */
public class Edge implements Comparable<Edge> {
    int a, b;
    double weight;
    public Edge(int v, int w, double weight) {
        a = v;
        b = w;
        this.weight = weight;
    }

    public Edge(Edge e) {
        a = e.v();
        b = e.w();
        this.weight= e.weight;
    }

    public int v() {
        return a;
    }

    public int w() {
        return b;
    }

    public double wt() {
        return weight;
    }

    public int other(int x) {
        return x == a ? b : a;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.wt() - o.wt() == 0) {
            return 0;
        } else if (this.wt() - o.wt() < 0) {
            return -1;
        } else {
            return 1;
        }
    }

    public String toString(){
        return "" + a + "-" + b + ": " + weight;
    }
}
