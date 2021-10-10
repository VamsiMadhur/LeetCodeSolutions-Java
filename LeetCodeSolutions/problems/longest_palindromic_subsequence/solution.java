class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int[][] dp = new int[n][n];
        
        for(int i=n-1; i>=0; i--) {
            dp[i][i] = 1;
            for(int j=i+1; j<n; j++) {
                char s1 = sa[i];
                char s2 = sa[j];
                
                if(s1 == s2) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}