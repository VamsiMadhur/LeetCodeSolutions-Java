class Solution {
    public int minCost(int[][] costs) {
        int[] cache = new int[3];
        for(int[] cost : costs) {
            int a = Math.min(cache[1], cache[2]) + cost[0];
            int b = Math.min(cache[0], cache[2]) + cost[1];
            int c = Math.min(cache[0], cache[1]) + cost[2];
            cache[0] = a;
            cache[1] = b;
            cache[2] = c;
        }
        return Math.min(cache[0], Math.min(cache[1], cache[2]));
    }
}