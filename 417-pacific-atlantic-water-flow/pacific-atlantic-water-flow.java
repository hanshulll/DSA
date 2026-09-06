class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n], atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            this.dfs(i, 0, heights, pacific);
        }
        for (int j = 0; j < n; j++) {
            this.dfs(0, j, heights, pacific);
        }

        for (int i = 0; i < m; i++) {
            this.dfs(i, n - 1, heights, atlantic);
        }

        for (int j = 0; j < n; j++) {
            this.dfs(m - 1, j, heights, atlantic);
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    answer.add(List.of(i, j));
                }
            }
        }
        return answer;
    }

    private void dfs(int i, int j, int[][] h, boolean[][] flow) {
        if (flow[i][j]) {
            return;
        }
        flow[i][j] = true;
        int[] direction = { -1, 0, 1, 0, -1 };
        for (int k = 0; k < direction.length - 1; k++) {
            int nRow = i + direction[k], nCol = j + direction[k + 1];
            if (nRow < h.length && nRow >= 0 && nCol < h[0].length && nCol >= 0
                    && h[nRow][nCol] >= h[i][j]) {
                dfs(nRow, nCol, h, flow);
            }
        }
    }
}