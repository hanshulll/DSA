class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
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
        int[] answer = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()) {
            int num = q.poll();
            answer[index++]=num;
            for(int i : adjList.get(num)) {
                indegree[i]--;
                if(indegree[i]==0) {
                    q.offer(i);
                }
            }
        }
        return index==numCourses?answer:new int[]{};
    }
}