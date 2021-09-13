class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2) {
            return Math.min(cost[0], cost[1]);
        }
        int first = cost[0];
        int second = cost[1];
        
        for(int i=2; i<cost.length; i++) {
            int temp = Math.min(first, second) + cost[i];
            first = second;
            second = temp;
        }
        return Math.min(first, second);
    }
}