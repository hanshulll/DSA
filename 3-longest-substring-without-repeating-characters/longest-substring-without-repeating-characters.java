class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0, j = 0;
        int[] freq = new int[128];
        for(int i = 0; i<s.length(); i++) {
            int indx = s.charAt(i);
            freq[indx]++;
            while(j<i && freq[indx]>1) {
                freq[s.charAt(j++)]--;
            }
            count = Math.max(count, i-j+1);
        }
        return count;
    }
}