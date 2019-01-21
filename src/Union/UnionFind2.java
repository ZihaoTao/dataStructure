package Union;

/**
 * Created by tino on 1/17/19.
 */
public class UnionFind2 {
    private int[] parent;
    private int count;
    private int[] sz; // sz[i] the number of elements whose roots are i

    public UnionFind2(int n) {
        count = n;
        parent = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        assert(p >= 0 && p <= count);
        while(p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        UnionFind2 uf = new UnionFind2(n);
        uf.unionElements(1, 10);
        uf.unionElements(100, 10);
        System.out.println(uf.isConnected(1, 100));

    }

}
