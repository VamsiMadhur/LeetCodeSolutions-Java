class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int noOfFresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    noOfFresh++;
                } else if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        int minutes = -1;
        
        if(noOfFresh == 0) return 0;
        if(queue.isEmpty()) return -1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
              minutes++;
            for(int i=0; i<size; i++) {
                int[] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];
                
                if(r<0 || r>=m || c<0 || c>=n || grid[r][c] == 0 || grid[r][c] == 3)
                    continue;
                
                if(grid[r][c] == 1) noOfFresh--; 
                if(noOfFresh <= 0) return minutes;
                
                grid[r][c] = 3;
                queue.offer(new int[]{r-1, c});
                queue.offer(new int[]{r+1, c});
                queue.offer(new int[]{r, c-1});
                queue.offer(new int[]{r, c+1});
                
               
                
            }
        }
        return -1;
    }
}