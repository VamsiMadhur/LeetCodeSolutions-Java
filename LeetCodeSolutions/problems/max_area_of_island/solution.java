class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int area = calculateArea(grid, i, j);
                    result = Math.max(area, result);
                }
            }
        }
        return result;
    }
    
    public int calculateArea(int[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        
        queue.add(new int[]{i,j});
        int area = 0;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];

            if(r<0 || r>=m || c<0 || c>=n || grid[r][c] != 1) continue;
            
            grid[r][c] = 2;
            area ++;
            
            queue.offer(new int[]{r-1,c});
            queue.offer(new int[]{r+1,c});
            queue.offer(new int[]{r,c-1});            
            queue.offer(new int[]{r,c+1});            
        }
        return area;
    }
}