class Solution {
    
    public int rows = 0;
    public int columns = 0;
    
    public void solve(char[][] board) {
        rows = board.length;
        columns = board[0].length;
        
        List<int[]> borders = new ArrayList<>();
        
        for(int i=0; i<rows; i++) {
            if(board[i][0] == 'O')
                borders.add(new int[] {i,0});
            if(board[i][columns-1] == 'O')
                borders.add(new int[] {i,columns-1});
        }
        
        for(int j=0; j<columns; j++) {
            if(board[0][j] == 'O')
                borders.add(new int[] {0,j});
            if(board[rows-1][j] == 'O')
                borders.add(new int[] {rows-1,j});
        }
        
        for(int[] borderCell : borders) {
            bfs(board, borderCell[0], borderCell[1]);
        }
        
        
        for(int r=0; r<rows; r++) {
            for(int c=0; c<columns; c++) {
                if(board[r][c] == 'E')
                    board[r][c] = 'O';
                else if(board[r][c] == 'O')
                    board[r][c] = 'X';
            }
        }
    }
    
    public void bfs(char[][] board, int r, int c) {
        if(board[r][c] != 'O') return;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];
            
            if(board[row][col] != 'O') continue;
            
            board[row][col] = 'E';
            if(col<this.columns-1)
                queue.offer(new int[]{row, col+1});
            if(row<this.rows-1)
                queue.offer(new int[]{row+1, col});
            if(col>0)
                queue.offer(new int[]{row, col-1});
            if(row>0)
                queue.offer(new int[]{row-1, col});
        }
    }
}