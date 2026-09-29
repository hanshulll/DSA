class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i : times) {
            int u = i[0], v = i[1], w = i[2];
            adj.get(u).add(new int[] { v, w });
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, k });
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w = curr[0], v = curr[1];
            if (dist[v] < w) {
                continue;
            }
            for (int[] i : adj.get(v)) {
                if (i[1] + w < dist[i[0]]) {
                    dist[i[0]] = i[1] + w;
                    pq.offer(new int[] { dist[i[0]] , i[0] });
                }
            }
        }

        int ans = 0;
        for (int i = 1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}