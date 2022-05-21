class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0]=0;
        for(int coin:coins) {
            for(int i=coin; i<max; i++ ) {
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}