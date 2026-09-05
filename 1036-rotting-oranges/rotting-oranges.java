class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int n = grid[i][j];
                if (n == 2) {
                    rottenQueue.add(new int[] { i, j });
                } else if (n == 1) {
                    freshOranges++;
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }

        int timeElapsed = 0;
        int[] direction = { -1, 0, 1, 0, -1 };
        while (!rottenQueue.isEmpty() && freshOranges>0) {
            timeElapsed++;
            int size = rottenQueue.size();
            for (int i = 0; i < size; i++) {
                int[] index = rottenQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextRow = index[0] + direction[j], nextCol = index[1] + direction[j + 1];
                    if (nextRow < grid.length && nextRow >= 0 && nextCol < grid[0].length && nextCol >= 0
                            && grid[nextRow][nextCol] == 1) {
                        rottenQueue.offer(new int[] { nextRow, nextCol });
                        grid[nextRow][nextCol]=2;
                        freshOranges--;
                    }
                }
            }
        }
        return freshOranges == 0 ? timeElapsed : -1;
    }
}