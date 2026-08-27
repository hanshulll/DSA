class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(new ArrayList<>(), nums, 0);
        return solution;
    }

    public void dfs(List<Integer> curr, int[] nums, int index) {
        solution.add(new ArrayList<>(curr));
        for(int i = index; i<nums.length; i++) {
            curr.add(nums[i]);
            dfs(curr, nums, i+1);
            curr.remove(curr.size()-1);
        }
    }
}