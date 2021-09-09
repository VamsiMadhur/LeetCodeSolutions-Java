class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] dp = new int[n][n];
        int largest = 0;
        
        Set<Integer> minesList = new HashSet<>();
        for(int[] mine : mines) {
            minesList.add(mine[0]*n + mine[1]);
        }
        
        int count = 0;
        for(int i=0; i<n; i++) {
            count = 0;
            for(int j=0; j<n; j++) {
                count = minesList.contains((i*n) + j) ? 0 : count+1;
                dp[i][j] = count;
            }
            
            count = 0;
            for(int j=n-1; j>=0; j--) {
                count = minesList.contains((i*n) + j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        
        for(int j=0; j<n; j++) {
            count = 0;
            for(int i=0; i<n; i++) {
                count = minesList.contains((i*n) + j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
       
            count = 0;
            for(int i=n-1; i>=0; i--) {
                count = minesList.contains((i*n) + j) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
                largest = Math.max(largest, dp[i][j]);
            }
        }
        
        return largest;
    }
}