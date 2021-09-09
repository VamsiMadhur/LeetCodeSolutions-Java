class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1,0}, {0,-1}, {0,1}};
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }
      
        int level = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] point = queue.poll();
                int r = point[0];
                int c = point[1];
                
                for(int[] dir : directions) {
                    int newR = r+dir[0];
                    int newC = c+dir[1];
                    
                    if(newR>=0 && newR<m && newC>=0 && newC<n 
                      && !visited[newR][newC] && grid[newR][newC] == 0) {
                        queue.offer(new int[] {newR, newC});
                        visited[newR][newC] = true;
                    }
                }
            }
            level++;
        }
        return level<=0 ? -1 : level;
    }
}