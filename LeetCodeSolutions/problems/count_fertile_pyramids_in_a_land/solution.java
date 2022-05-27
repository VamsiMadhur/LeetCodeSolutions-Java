class Solution {
    public int countPyramids(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        int[][] dp = new int[m][n];
        
        for(int i=m-2; i>=0; i--) {
            for(int j=1; j<n-1; j++) {
                if(grid[i][j] == 1 && grid[i+1][j] == 1 && 
                   grid[i+1][j-1] == 1 && grid[i+1][j+1] == 1) {
                    dp[i][j] = Math.min(dp[i+1][j], 
                                        Math.min(dp[i+1][j-1], dp[i+1][j+1])) + 1;
                    result += dp[i][j];
                }
            }
        }
        
        dp = new int[m][n];
        for(int i=1; i<=m-1; i++) {
            for(int j=1; j<n-1; j++) {
                if(grid[i][j] == 1 && grid[i-1][j] == 1 && 
                   grid[i-1][j-1] == 1 && grid[i-1][j+1] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], 
                                        Math.min(dp[i-1][j-1], dp[i-1][j+1])) + 1;
                    result += dp[i][j];
                }
            }
        }
        return result;
    }
}