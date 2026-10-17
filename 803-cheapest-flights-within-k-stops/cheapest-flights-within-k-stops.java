class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] { src, 0 });
        int stop = 0;
        while (!q.isEmpty() && stop <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] o : adjList.get(curr[0])) {
                    int neighbour = o[0], dist = o[1];
                    if (curr[1] + dist >= minDist[neighbour]) {
                        continue;
                    }
                    minDist[neighbour] = curr[1] + dist;
                    q.offer(new int[] { neighbour, (curr[1] + dist) });
                }
            }
            stop++;
        }
        return minDist[dst] == Integer.MAX_VALUE ? -1 : minDist[dst];
    }
}