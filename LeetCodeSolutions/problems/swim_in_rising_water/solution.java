class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int visited[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                visited[i][j] = -1;
            }
        }
        
        boolean present[][] = new boolean[n][n];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = grid[0][0];
        present[0][0] = true;
        
        
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0];
            int j = point[1];
            present[i][j] = false;
            
            //North
           if(i>0) {
                int currVal = Math.max(visited[i][j], grid[i-1][j]);
                if(visited[i-1][j] == -1 || currVal < visited[i-1][j]) {
                    visited[i-1][j] = currVal;
                    
                    if(!present[i-1][j]) {
                        queue.offer(new int[]{i-1, j});
                        present[i-1][j] = true;
                    }
                }
            }
            
            //South
            if(i<n-1) {
                int currVal = Math.max(visited[i][j], grid[i+1][j]);
                if(visited[i+1][j] == -1 || currVal < visited[i+1][j]) {
                    visited[i+1][j] = currVal;
                    
                    if(!present[i+1][j]) {
                        queue.offer(new int[]{i+1, j});
                        present[i+1][j] = true;
                    }
                } 
            }
            
            //West
            if(j>0) {
                int currVal = Math.max(visited[i][j], grid[i][j-1]);
                if(visited[i][j-1] == -1 || currVal < visited[i][j-1]) {
                    visited[i][j-1] = currVal;
                    
                    if(!present[i][j-1]) {
                        queue.offer(new int[]{i, j-1});
                        present[i][j-1] = true;
                    }
                }
            }
            
            //East
            if(j<n-1) {
                int currVal = Math.max(visited[i][j], grid[i][j+1]);
                if(visited[i][j+1] == -1 || currVal < visited[i][j+1]) {
                    visited[i][j+1] = currVal;
                    
                    if(!present[i][j+1]) {
                        queue.offer(new int[]{i, j+1});
                        present[i][j+1] = true;
                    }
                }
            }
        }
        return visited[n-1][n-1];
        
    }
}