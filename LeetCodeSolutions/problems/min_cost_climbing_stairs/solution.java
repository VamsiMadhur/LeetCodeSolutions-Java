class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int f0 = cost[0];
        int f1 = cost[1];
        for(int i=2; i<cost.length; i++) {
            int temp = cost[i] + Math.min(f0, f1);
            f0 = f1;
            f1 = temp;
        }
        return Math.min(f0, f1);
    }
}