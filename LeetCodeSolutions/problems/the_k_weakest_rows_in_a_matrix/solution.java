class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] ans = new int[k];
        int cnt = 0;
        
        for(int j=0; j<cols; j++) {
            for(int i=0; i<rows; i++) {
                if(mat[i][j] == 0 && (j==0 || mat[i][j-1] == 1)) {
                    ans[cnt++] = i;
                    if(cnt == k) return ans;
                }
            }
        }
        
        for(int i=0; i<rows; i++) {
            if(mat[i][cols-1] == 1) {
                ans[cnt++] = i;
                if(cnt == k) return ans;
            }
        }
        
        return ans;
    }
}