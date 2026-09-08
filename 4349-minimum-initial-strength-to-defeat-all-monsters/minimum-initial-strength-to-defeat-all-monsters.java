class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] boost = new long[n+1];
        for(int i[] : boosts) {
            boost[i[0]]+=i[2];
            boost[i[1]+1]-=i[2];
        }
        long maxSum = 0;
        for(int i = 1; i<boost.length; i++) {
            boost[i]+=boost[i-1];
            maxSum+=monsters[i-1];
        }
        long left = 0, right = maxSum, answer = 0;
        while(left<=right) {
            long mid = left+(right-left)/2;
            if(isValidStrength(mid, monsters, boost)) {
                answer=mid;
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return answer;
    }

    private boolean isValidStrength(long mid, int[] monsters, long[] bonus) {
        for(int i = 0; i<monsters.length; i++) {
            if(mid+bonus[i]>=monsters[i]) {
                mid=Math.max(0L, mid-monsters[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}