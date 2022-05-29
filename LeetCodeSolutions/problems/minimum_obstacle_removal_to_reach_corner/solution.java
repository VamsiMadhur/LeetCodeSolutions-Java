class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        dp[0][0] = grid[0][0] + 1;
        int t=0;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int i = temp[0], j = temp[1];
            if(i>0) {
                 t = dp[i][j] + grid[i-1][j];
                if(dp[i-1][j] == 0 || t < dp[i-1][j]) {
                     dp[i-1][j] = t;
                    queue.offer(new int[]{i-1, j});
                }
            }
            if(i < m-1) {
                 t = dp[i][j] + grid[i+1][j];
                if(dp[i+1][j] == 0 || t < dp[i+1][j]) {
                    dp[i+1][j] = t;
                    queue.offer(new int[]{i+1, j});                
                }
            }
            if(j>0) {
                 t = dp[i][j] + grid[i][j-1];
                if(dp[i][j-1] == 0 || t < dp[i][j-1]) {
                    dp[i][j-1] = t;
                    queue.offer(new int[]{i, j-1});
                }
            }
            if(j < n-1) {
                 t = dp[i][j] + grid[i][j+1];
                if(dp[i][j+1] == 0 || t < dp[i][j+1]) {
                    dp[i][j+1] = t;
                    
                    queue.offer(new int[]{i, j+1});                
                }
            }
        }
        return dp[m-1][n-1] - 1;
    }
}