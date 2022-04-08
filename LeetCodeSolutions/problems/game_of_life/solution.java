class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = 0;
                if(i>0) count += board[i-1][j]%10;
                if(i<m-1) count += board[i+1][j]%10;
                
                if(j>0) count += board[i][j-1]%10;
                if(j<n-1) count += board[i][j+1]%10;
                
                if(i>0 && j>0) count += board[i-1][j-1]%10;
                if(i>0 && j<n-1) count += board[i-1][j+1]%10;
                if(i<m-1 && j>0) count += board[i+1][j-1]%10;
                if(i<m-1 && j<n-1) count += board[i+1][j+1]%10;
                
                if(board[i][j]%10 == 1 && (count==2 || count==3)) 
                    board[i][j] += 10;
                if(board[i][j]%10 == 0 && count==3)
                    board[i][j] += 10;
            }
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] >= 10) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}