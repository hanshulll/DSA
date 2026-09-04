class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited= new boolean[nums.length];
        dfs(nums, new ArrayList<>());
        return answer;
    }

    private void dfs(int[] nums, List<Integer> temp) {
        if(temp.size()==nums.length) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(visited[i]) continue;
            visited[i]=true;
            temp.add(nums[i]);
            dfs(nums,temp);
            visited[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}