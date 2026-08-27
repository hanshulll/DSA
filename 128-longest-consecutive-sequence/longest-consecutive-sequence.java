class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for(int i = 0; i<nums.length; i++) {
            elements.add(nums[i]);
        }
        int length = 0;
        for(int i : elements) {
            if(elements.contains(i-1)) continue;
            int val = i, count = 1;
            while(elements.contains(val+1)) {
                val++;
                count++;
            }
            length=Math.max(length,count);
        }
        return length;
    }
}