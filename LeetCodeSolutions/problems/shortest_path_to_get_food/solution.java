class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '#') {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int noOfSteps = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            noOfSteps++;
            
            for(int i=0; i<size; i++) {
                int[] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];
                
                if(r<0||r>=m||c<0||c>=n||grid[r][c] == 'X')
                    continue;
                
                if(grid[r][c] == '*') return noOfSteps;
                
                grid[r][c] = 'X';
                queue.offer(new int[]{r-1, c});
                queue.offer(new int[]{r+1, c});
                queue.offer(new int[]{r, c-1});
                queue.offer(new int[]{r, c+1});
            }
        }
        return -1;
    }
}