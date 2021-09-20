class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        for(int i=0; i<4 && i<moves.length; i++) {
            board[moves[i][0]][moves[i][1]] = (i%2)+2;
        }
        for(int i=4; i<moves.length; i++) {
            board[moves[i][0]][moves[i][1]] = (i%2)+2;
            String winner = isWin(board);
            if(!"".equals(winner)) {
                return winner;
            }
        }
        if(moves.length < 9) return "Pending";
        return "Draw";
    }
    
    public String isWin(int[][] board) {
        for(int i=0; i<3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if(board[i][0] == 2) return "A";
                else if(board[i][0] == 3) return "B";
            }
        }
        for(int i=0; i<3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if(board[0][i] == 2) return "A";
                else if(board[0][i] == 3) return "B";
            }
        }
        
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if(board[0][0] == 2) return "A";
            else if(board[0][0] == 3) return "B";
        }
        
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if(board[0][2] == 2) return "A";
            else if(board[0][2] == 3) return "B";
        }
        return "";
    }
}