class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Dsu d = new Dsu(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            // for(int j = 0; j<edges[i].length; j++) {
            if (d.union(edges[i][0], edges[i][1])) {
                return new int[] { edges[i][0], edges[i][1] };
            }
            // }
        }
        return new int[] {};
    }

    class Dsu {
        int[] parent, size;

        public Dsu(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findParent(int v) {
            if (parent[v] == v)
                return v;
            return parent[v] = findParent(parent[v]);
        }

        public boolean union(int a, int b) {
            int aParent = findParent(a), bParent = findParent(b);
            if (aParent == bParent)
                return true;
            if (aParent < bParent) {
                parent[aParent] = bParent;
                size[bParent] += size[aParent];
            } else {
                parent[bParent] = aParent;
                size[aParent] += size[bParent];
            }
            return false;
        }
    }
}