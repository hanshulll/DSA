class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
      for(int i = 0; i<indegree.length; i++) {
        if(indegree[i]==0) {
            q.offer(i);
        }
      }
      int count = 0;
      while(!q.isEmpty()) {
        int node = q.poll();
        count++;
        for(int i : adjList.get(node)) {
            indegree[i]--;
            if(indegree[i]==0) {
                q.offer(i);
            }
        }
      }
      return numCourses==count?true:false;
    } 
}