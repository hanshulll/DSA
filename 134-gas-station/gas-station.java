class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for(int i = 0; i<gas.length; i++) {
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas<totalCost) {return -1;}
        totalGas = 0;
        int index = 0;
        for(int i = 0; i<gas.length; i++) {
            totalGas+=gas[i];
            totalGas-=cost[i];
            if(totalGas<0) {
                totalGas=0;
                index=i+1;
            }
        }
        return index;
    }
}