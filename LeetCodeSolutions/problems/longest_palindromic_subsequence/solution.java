class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        
        char[] sa = new char[n+1];
        sa[0] = '0'; int count = 1;
        for(char c : s.toCharArray()) {
            sa[count++] = c;
        }
        
        int[][] dp = new int[n+1][n+1];
        
        for(int i=n; i>=1; i--) {
            dp[i][i] = 1;
            for(int j=i+1; j<=n; j++) {
                char s1 = sa[i];
                char s2 = sa[j];
                
                if(s1 == s2) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[1][n];
    }
}