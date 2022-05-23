class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String str : strs) {
            int k=0, l=0;
            for(char c : str.toCharArray()) {
                if(c == '0') k++;
                else if(c == '1') l++;
            }
            for(int i=m; i>=k; i--) {
                for(int j=n; j>=l; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-k][j-l]+1);
                }
            }
        }
        return dp[m][n];
    }
}