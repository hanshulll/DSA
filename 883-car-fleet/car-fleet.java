class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            freq.put(position[i], i);
        }
        int ans = 0;
        float prevTime = 0;
        Arrays.sort(position);
        for (int i = position.length - 1; i >= 0; i--) {
            float curTime = (float)(target - position[i]) / speed[freq.get(position[i])];
            if (curTime > prevTime) {
                ans++;
                prevTime = curTime;
            }
        }
        return ans;
    }
}