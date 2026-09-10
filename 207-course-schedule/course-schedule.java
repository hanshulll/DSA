class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i[] : prerequisites) {
            indegree[i[0]]++;
            adjList.computeIfAbsent(i[1],k->new ArrayList<>()).add(i[0]);
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
            for(Integer i : adjList.getOrDefault(num, new ArrayList<>())) {
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        return count==numCourses?true:false;
    }
}