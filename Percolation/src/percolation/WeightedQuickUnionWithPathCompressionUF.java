/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percolation;

/**
 *
 * @author farukmoralioglu
 */
public class WeightedQuickUnionWithPathCompressionUF {

    private final int[] parent;
    private final int[] size;
    private int componentCount;

    public WeightedQuickUnionWithPathCompressionUF(int n) {
        componentCount = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getComponentCount() {
        return componentCount;
    }

    public int findRoot(int p) {
        int root = p;
        while (root != parent[root]) {
            parent[root] = parent[parent[root]]; //path compression
            root = parent[root];
        }
        return root;
    }

    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        if (rootP == rootQ) {
            return;
        }
        //weighting according to size
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        componentCount--;
    }
    
}

