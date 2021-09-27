class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        
        int c[][] = new int[m+1][n+1];
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(a[i-1] == b[j-1]) {
                    c[i][j] = c[i-1][j-1] + 1;
                } else if(c[i-1][j] > c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                } else {
                    c[i][j] = c[i][j-1];
                }
            }
        }
        return c[m][n];
    }
}