class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Dsu union = new Dsu(edges.length+1);
        for(int i = 0; i<edges.length; i++) {
            if(!union.union(edges[i][0],edges[i][1])) {
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[]{};
    }

    class Dsu {
        int[] parent, size;
        public Dsu(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for(int i = 0; i<n; i++) {
                parent[i]=i;
                size[i]=1;
            }
        }

            private int findParent(int n) {
                if(parent[n]==n) return n;
                return parent[n]=findParent(parent[n]);
            }

            public boolean union(int i, int j) {
                int rootI = this.findParent(i), rootJ = this.findParent(j);
                if(rootI==rootJ) return false;
                if(rootI<rootJ) {
                    parent[rootI]=rootJ;
                    size[rootJ]+=size[rootI];
                } else {
                    parent[rootJ]=rootI;
                    size[rootI]+=size[rootJ];
                }
                return true;
            }
    }
}