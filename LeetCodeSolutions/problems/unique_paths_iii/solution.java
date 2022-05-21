class Solution {
    int noOfSteps = 0;
    public int uniquePathsIII(int[][] grid) {
        
        int startI = 0, startJ=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    startI = i; startJ = j;
                    noOfSteps++;
                } else if(grid[i][j] == 0) {
                    noOfSteps++;
                }
            }
        }
        return dfs(grid, startI, startJ);
    }
    
    public int dfs(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || 
           grid[i][j] == -1 || grid[i][j] >= 3 || 
          (grid[i][j] == 2 && noOfSteps!=0)) return 0;
        
        if(grid[i][j] == 2 && noOfSteps == 0) return 1;
        
        noOfSteps--;
        
        int count = 0;
        grid[i][j] += 3;
        count += dfs(grid, i+1, j);
        count += dfs(grid, i-1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i, j-1);
        grid[i][j] -= 3;
        noOfSteps++;
        return count;
    }
}