class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length; 
        int[][] grid = new int[n][n];
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                int[] fi = points[i], se = points[j];
                int manhattanD = Math.abs(fi[0]-se[0])+Math.abs(fi[1]-se[1]);
                grid[i][j]=manhattanD;
                grid[j][i]=manhattanD;
            }
        }
        int[] minDistance = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        int distSum = 0;
        minDistance[0]=0;
        for(int i = 0; i<n; i++) {
            int minIndex = -1;
            for(int k = 0; k<n; k++) {
                if(!visited[k] && (minIndex==-1 || minDistance[k]<minDistance[minIndex])) {
                    minIndex=k;
                }
            }
            visited[minIndex]=true;
            distSum+=minDistance[minIndex];
            for(int k = 0; k<n; k++) {
                if(!visited[k]) {
                    minDistance[k] = Math.min(minDistance[k], grid[minIndex][k]);
                }
            }
        }
        return distSum;
    }
}