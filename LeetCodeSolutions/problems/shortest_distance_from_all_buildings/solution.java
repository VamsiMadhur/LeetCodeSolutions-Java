class Solution {
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int totalHouses = 0;
        
        int[][][] distances = new int[m][n][2];
        
        List<Integer> houses = new ArrayList<>();
        int emptyLand = 0;
        for(int row = 0; row < m; row++) {
            for(int column = 0; column < n; column++) {
                if(grid[row][column] == 1) {
                    totalHouses++;
                    bfs(grid, distances, row, column, emptyLand);
                    emptyLand--;
                }
            }
        }
        
        int minDistance = Integer.MAX_VALUE;
        for(int row = 0; row < m; row++) {
            for(int column = 0; column < n; column++) {
                if(distances[row][column][1] == totalHouses) {
                    minDistance = Math.min(distances[row][column][0], minDistance);
                }
            }
        }
        return minDistance==Integer.MAX_VALUE ? -1 : minDistance;
    }
    
    private void bfs(int[][] grid, int[][][] distances, int row, int column, int emptyLand) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, column, 0});
        
        queue.add(new int[]{row+1, column, 1});
        queue.add(new int[]{row-1, column, 1});
        queue.add(new int[]{row, column+1, 1});
        queue.add(new int[]{row, column-1, 1});
        
        int steps = 0;
        
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0];
            int c = point[1];
            int d = point[2];
       
            if(r<0 || c<0 || r>=m || c>=n || grid[r][c] < emptyLand || grid[r][c] == 2)
                continue;
       
            if(grid[r][c] == emptyLand) {
                grid[r][c]--;
                distances[r][c][0] += d;
                distances[r][c][1] ++;
                
                queue.add(new int[]{r+1, c, d+1});
                queue.add(new int[]{r-1, c, d+1});
                queue.add(new int[]{r, c+1, d+1});
                queue.add(new int[]{r, c-1, d+1});
            }  
        }
    }
}