package Union;

/**
 * Created by tino on 1/17/19.
 */
public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int n) {
        count = n;
        id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        assert(p >= 0 && p <= count);
        return id[p];
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if(pid != qid) {
            for(int i = 0; i < count; i++) {
                if(id[i] == pid) {
                    id[i] = qid;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000;
        UnionFind uf = new UnionFind(n);
        uf.unionElements(1, 10);
        uf.unionElements(100, 10);
        System.out.println(uf.isConnected(1, 100));
    }
}
