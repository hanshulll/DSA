class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int left = 0, count = 0;
        for(int right = 0; right<s.length(); right++) {
            arr[s.charAt(right)]++;
            while(arr[s.charAt(right)]>1) {
                arr[s.charAt(left++)]--;
            }
            count = Math.max(count,right-left+1);
        }
        return count;
    }
}