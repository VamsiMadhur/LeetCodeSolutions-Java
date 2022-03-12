class Solution {
    char[] word;
    boolean[][] visited;
    int m=0, n=0;
    char[][] board;
    boolean found = false;
    
    public boolean exist(char[][] board, String wordS) {
        this.board = board;
        
        m = board.length;
        n = board[0].length;
        
        word = wordS.toCharArray();
        
        if(word.length > m*n) return false;
        
        visited = new boolean[m][n];
        
        for(int k=1; k<word.length; k++) {
            boolean temp = false;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(word[k] == board[i][j]) {
                        temp = true;
                        break;
                    }
                }
            }
            if(!temp) return false;
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(word[0] == board[i][j]) {
                    dfs(i, j, 0);
                    if(found) return true;
                }
            }
        }
        return found;
    }
    
    public void dfs(int i, int j, int pos) {
        if(found) return;

        if(pos == word.length) {
            found = true;
            return;
        }
        
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || board[i][j] != word[pos]) return;
        
        visited[i][j] = true;
        dfs(i+1, j, pos+1);
        dfs(i-1, j, pos+1);
        dfs(i, j+1, pos+1);
        dfs(i, j-1, pos+1);
        visited[i][j] = false;
    }
}