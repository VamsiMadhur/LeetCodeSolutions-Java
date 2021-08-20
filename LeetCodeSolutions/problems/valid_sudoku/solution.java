class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isHValid(board) && isVValid(board) && isSValid(board);
    }
    
    public int check(char[][] board, int i, int j, int seen) {
        
        if(board[i][j] == '.') return seen;
        
        int num = board[i][j] - '0';
        
        int curr = 1 << (num-1);
        if((seen & curr) >= 1) return -seen;
        
        return seen|curr;
    }
    
    public boolean isHValid(char[][] board) {
        for(int i=0; i<9; i++) {
            int seen = 0;
            for(int j=0; j<9; j++) {
                seen = check(board, i, j, seen);
                if(seen < 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isVValid(char[][] board) {
        for(int j=0; j<9; j++) {
            int seen = 0;
            for(int i=0; i<9; i++) {
                seen = check(board, i, j, seen);
                if(seen < 0) {
                    return false;
                }

            }
        }
        return true;
    }
    
    public boolean isSValid(char[][] board) {
        for(int i=0; i<9; i=i+3) {
            for(int j=0; j<9; j=j+3) {
                int seen = 0;
                
                seen = check(board, i, j, seen);
                if(seen < 0) return false;
                
                seen = check(board, i+1, j, seen);
                if(seen < 0) return false;
                
                seen = check(board, i+2, j, seen);
                if(seen < 0) return false;
                    
                seen = check(board, i, j+1, seen);
                if(seen < 0) return false;

                seen = check(board, i+1, j+1, seen);
                if(seen < 0) return false;

                seen = check(board, i+2, j+1, seen);
                if(seen < 0) return false;

                seen = check(board, i, j+2, seen);
                if(seen < 0) return false;


                seen = check(board, i+1, j+2, seen);
                if(seen < 0) return false;


                seen = check(board, i+2, j+2, seen);
                if(seen < 0) return false;
            }
        }
        return true;
    }
}