class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) {
            int[] ans = new int[numCourses];
            for(int i = 0; i<numCourses; i++) {
                ans[i]=i;
            }
            return ans;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] i : prerequisites) {
                indegree[i[0]]++;
                adjList.get(i[1]).add(i[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++) {
            if(indegree[i]==0) {
                q.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int index=0;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans[index++]=node;
            for(int i : adjList.get(node)) {
                indegree[i]--;
                if(indegree[i]==0) {
                    q.offer(i);
                }
            }
        }
        return index==numCourses?ans:new int[]{};
    }
}