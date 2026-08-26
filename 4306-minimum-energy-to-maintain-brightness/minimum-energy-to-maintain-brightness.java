class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        long minBulbNeeded = (brightness+3-1)/3;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        long currentStart = intervals[0][0], currentEnd = intervals[0][1];
        long ans = 0;
        for(int i = 1; i<intervals.length; i++) {
            long nextStart = intervals[i][0], nextEnd = intervals[i][1];
            if(nextStart<=currentEnd && currentEnd<nextEnd) {
                currentEnd = nextEnd;
            } else if(currentEnd<nextEnd) {
                ans += (currentEnd-currentStart+1)*minBulbNeeded;
                currentEnd=nextEnd;
                currentStart=nextStart;
            }
        }
        ans += (currentEnd-currentStart+1)*minBulbNeeded;
        return ans;
    }
}