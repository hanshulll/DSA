class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] bonus = new long[n+1];
        for(int[] i : boosts) {
            bonus[i[0]]+=i[2];
            bonus[i[1]+1]-=i[2];
        }
        for(int i = 1; i<bonus.length; i++) {
            bonus[i]+=bonus[i-1];
        }
        long l = 0, r = (long)1e18, strength = -1;
        while(l<=r) {
            long mid = l+(r-l)/2;
            if(isValidStrength(mid, monsters, bonus)) {
                strength=mid;
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return strength;
    }

    private boolean isValidStrength(long mid, int[] monsters, long[] bonus) {
        for(int i = 0; i<monsters.length; i++) {
            if(mid+bonus[i]>=monsters[i]) {
                mid=Math.max(0,mid-monsters[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}