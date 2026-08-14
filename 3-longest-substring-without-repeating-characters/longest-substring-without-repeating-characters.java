class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0, index = 0;
        for(char c : s.toCharArray()) {
            while(!set.add(c)) {
                set.remove(s.charAt(index++));
            }
            count = Math.max(count, set.size());
        }
        return count;
    }
}