class Solution {
    public int countValidPrefixes(String s) {
        int zeroCount = 0, onesCount = 0, ans = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i)=='0') {
                zeroCount++;
            } else {
                onesCount++;
            }
            if(Math.abs(onesCount-zeroCount)<=1) {
                ans++;
            }
        }
        return ans;
    }
}