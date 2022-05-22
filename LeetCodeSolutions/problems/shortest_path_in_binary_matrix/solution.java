class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        grid[0][0] = -1;
        queue.offer(new int[]{0,0});
        int size = 1, noOfSteps = 0;
        while(size != 0) {
            int nextSize = 0;
            noOfSteps++;
            for(int k=0; k<size; k++) {
                int[] temp = queue.poll();
                int i = temp[0], j = temp[1];
                if(i == n-1 && j == n-1) return noOfSteps;
                 if(i<n-1) {
                    if(j>0 && grid[i+1][j-1] == 0) {
                        grid[i+1][j-1] = -1;
                        queue.offer(new int[]{i+1, j-1});
                        nextSize++;
                    }
                    if(grid[i+1][j] == 0) {
                        grid[i+1][j] = -1;
                        queue.offer(new int[]{i+1, j});
                        nextSize++;
                    }
                    if(j < n-1 && grid[i+1][j+1] == 0) {
                        grid[i+1][j+1] = -1;
                        queue.offer(new int[]{i+1, j+1});
                        nextSize++;
                    }
                }
                
                if(j>0 && grid[i][j-1] == 0) {
                    grid[i][j-1] = -1;
                    queue.offer(new int[]{i, j-1});
                    nextSize++;
                }
                if(j < n-1 && grid[i][j+1] == 0) {
                    grid[i][j+1] = -1;
                    queue.offer(new int[]{i, j+1});
                    nextSize++;
                }
                
                if(i>0) {
                    if(j>0 && grid[i-1][j-1] == 0) {
                        grid[i-1][j-1] = -1;
                        queue.offer(new int[]{i-1, j-1});
                        nextSize++;
                    }
                    if(grid[i-1][j] == 0) {
                        grid[i-1][j] = -1;
                        queue.offer(new int[]{i-1, j});
                        nextSize++;
                    }
                    if(j < n-1 && grid[i-1][j+1] == 0) {
                        grid[i-1][j+1] = -1;
                        queue.offer(new int[]{i-1, j+1});
                        nextSize++;
                    }
                }
               
            }
            size = nextSize;
        }
        
        return -1;
    }
}