class Solution {
    int n = 3;
    int N = n*n;
    
    int[][] rows = new int[N][N];
    int[][] columns = new int[N][N];
    int[][] boxes = new int[N][N];
    
    char[][] board;
    
    boolean sudokuSolved = false;
    
    public boolean couldPlace(int d, int row, int col) {
        
        int boxId = (row/n)*n + col/n;
        d--;
        return rows[row][d] + columns[col][d] + boxes[boxId][d] == 0;
    }
    
    public void placeNumber(int d, int row, int col) {
        int boxId = (row/n)*n + col/n;
        d--;
        
        rows[row][d]++;
        columns[col][d]++;
        boxes[boxId][d]++;
        board[row][col] = (char)(d+'1');
    }
    
     public void removeNumber(int d, int row, int col) {
         int boxId = (row/n)*n + col/n;
         d--;
         
        rows[row][d]--;
        columns[col][d]--;
        boxes[boxId][d]--;
        board[row][col] = '.';
    }
    
    public void placeNextNumber(int row, int col) {
        
        if((col == N-1) && (row == N-1)) {
            sudokuSolved = true;
        } else {
            if(col == N-1) backtrack(row+1, 0);
            else backtrack(row, col+1);
        }
    }
    
    public void backtrack(int row, int col) {
        if(board[row][col] == '.') {
            for(int d=1; d<=9; d++) {
                if(couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumber(row, col);
                    
                    if(!sudokuSolved) removeNumber(d, row, col);
                }
            }
        }
        else {
            placeNextNumber(row, col);
        }
        
    }
    
    public boolean couldPlaceOnlyOne(int row, int col) {
        
        int place = 0, count = 0;
        for(int d=1; d<=9; d++) {
            if(couldPlace(d, row, col)) {
                count++;
                place = d;
            }
        }
        if(count == 1) {
            placeNumber(place, row, col);
            return true;
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                char num = board[i][j];
                if(num != '.') {
                    int d = num - '0';
                    placeNumber(d, i, j);
                }
            }
        }
        
        while(true) {
            int flag = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(board[i][j] == '.')
                        if(couldPlaceOnlyOne(i, j)) flag = 1;
                }
            }
            if(flag == 0) break;
        }
        
        backtrack(0,0);
    }
}