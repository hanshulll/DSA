class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length, count = 0;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
