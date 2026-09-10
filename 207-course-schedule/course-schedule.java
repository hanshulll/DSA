class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i[] : prerequisites) {
            indegree[i[0]]++;
            adjList.get(i[1]).add(i[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++) { 
            if(indegree[i]==0) {
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            count++;
            int num = q.poll();
            for(Integer i : adjList.get(num)) {
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        return count==numCourses?true:false;
    }
}