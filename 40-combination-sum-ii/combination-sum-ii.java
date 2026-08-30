class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, 0, new ArrayList<>());
        return answer;
    }
    private void dfs(int index, int[] candidates, int target, int sum, List<Integer> curList) {
        if(sum>target) return;
        else if(sum==target) {
            answer.add(new ArrayList<>(curList));
            return;  
        }
        for(int i = index; i<candidates.length; i++) {
            if(i>index && candidates[i]==candidates[i-1]) continue;
            curList.add(candidates[i]);
            sum+=candidates[i];
            dfs(i+1 , candidates, target, sum, curList);
            curList.remove(curList.size()-1);
            sum-=candidates[i];
        }
    }
}