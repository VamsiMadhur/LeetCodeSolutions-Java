class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean [n][n];
        char[] sa = s.toCharArray();
        
        int maxLength = 0;
        int x=0; int y=0;
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            if(i!= n-1 && sa[i] == sa[i+1]) {
                maxLength = 2;
                dp[i][i+1] = true;
                x = i;
                y = i+1;
            }
        }
        
        for(int i=n-3; i>=0; i--) {
            for(int j=i+2; j<n; j++) {
                if(sa[i] == sa[j] && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    if(j-i+1 > maxLength) {
                        x=i;
                        y=j;
                        maxLength = j-i+1;
                    }
                } 
            }
        }
        return s.substring(x, y+1);
    }
}