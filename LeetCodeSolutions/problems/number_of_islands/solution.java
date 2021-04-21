class Solution {
    public int rows = 0;
    public int columns = 0;
    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length;
        columns = grid[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(grid[i][j]=='1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        if(grid[i][j] != '1') return;
        
        grid[i][j] = '2';
        if(i>0) {
            dfs(grid, i-1, j);
        } 
        if(i<rows-1) {
            dfs(grid, i+1, j);
        }
        if(j>0) {
            dfs(grid, i, j-1);
        } 
        if(j<columns-1) {
            dfs(grid, i, j+1);
        }
    }
}