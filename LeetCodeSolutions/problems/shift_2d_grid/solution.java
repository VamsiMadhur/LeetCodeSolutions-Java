class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
       int[][] result = new int[m][n];
        
        if(k%(m*n) == 0) {
             return (List)Arrays.asList(grid);
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int idx = (i*n) + j + k;
                int newI = (idx/n)%m;
                int newJ = idx%n;
               result[newI][newJ] = grid[i][j];
            }
        }
        return (List)Arrays.asList(result);
    }
}