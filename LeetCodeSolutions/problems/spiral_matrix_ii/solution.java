class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int total = n*n;
        int count = 0;
        int sh = 0, eh = n-1;
        int sv = -1, ev = n-1;
        int i=0, j=0, nexti = 0, nextj = 1;
        while(count<total) {
            res[i][j] = ++count;
            if(i==sh && j==ev) {
                nextj = 0;
                nexti = 1;
                sv++;
            } else if(i==eh && j==ev) {
                nexti = 0;
                nextj = -1;
                sh++;
            } else if(i==eh && j==sv) {
                nextj = 0;
                nexti = -1;
                ev--;
            } else if(i==sh && j==sv) {
                nexti = 0;
                nextj = 1;
                eh--;
            }
            
            i += nexti;
            j += nextj;
        }
        return res;
        
    }
}