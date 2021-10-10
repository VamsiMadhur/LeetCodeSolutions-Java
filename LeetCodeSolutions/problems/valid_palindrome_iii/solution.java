class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for(int i=n-2; i>=0; i--) {
            for(int j=i+1; j<n; j++) {
                char sa = s.charAt(i);
                char ta = s.charAt(j);
                if(sa == ta) {
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = 1+Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[0][n-1] <= k;
    }
}