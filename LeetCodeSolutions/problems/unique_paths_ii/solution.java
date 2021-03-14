class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        obstacleGrid[0][0] = 1;
        
        for(int i=1; i<rows; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0]==0 && obstacleGrid[i-1][0]==1) ? 1 : 0;
        }
        
        for(int i=1; i<columns; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i]==0 && obstacleGrid[0][i-1]==1) ? 1 : 0;
        }
        
        for(int i=1; i<rows; i++) {
            for(int j=1; j<columns; j++) {
                if(obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        
        return obstacleGrid[rows-1][columns-1];
    }
}