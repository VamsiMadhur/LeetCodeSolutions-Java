class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                boolean flag = (i==j || i==n-1-j);
                if((flag && grid[i][j] == 0) || (!flag && grid[i][j] != 0))
                    return false;
            }
        }
        return true;
    }
}