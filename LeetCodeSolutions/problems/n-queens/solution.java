class Solution {
    char[][] board;
    List<List<String>> result = new ArrayList<>();
    int size=0;
    public List<List<String>> solveNQueens(int n) {
        size=n;
        
        if(n==1) {
            result.add(new ArrayList<>(){{add("Q");}});
            return result;
        } else if(n==2 || n==3) {
            return result;
        }
        this.board = new char[n][n];

        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                board[i][j] = '.';

        for(int i=0; i<n; i++)
                helper(0, i, n);
        
        return result;
    }
    
    public void helper(int i, int j, int n) {
        board[i][j] = 'Q';
        n--;
        
        if(n==0)  toString(board);
        
        for(int r=i+1; r<size; r++) {
            for(int c=0; c<size; c++) {
                if(isValid(r, c))
                    helper(r, c, n);
            }
        }
        board[i][j] = '.';
    }
    
    public boolean isValid(int r, int c) {
        for(int i=0; i<r; i++) {
            if(board[i][c] == 'Q') return false;
        }
        
        for(int i=0; i<size; i++) {
            if(i == r) continue;
            if(board[r][i] == 'Q') return false;
        }
        
        int i=r-1, j=c-1;
        while(i>=0 && j>=0) {
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }
        
        i=r-1; j=c+1;
        while(i>=0 && j<size) {
            if(board[i][j] == 'Q') return false;
            i--;
            j++;
        }
        return true;
    }
    
    public void toString(char[][] board) {
        List<String> temp = new ArrayList<>();

        for(int i=0; i<size; i++) 
            temp.add(new String(board[i]));
        
        result.add(temp);
    }
}