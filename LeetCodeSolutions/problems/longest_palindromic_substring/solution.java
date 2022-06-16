class Solution {
    int x=0, y=0, n=0;
    public String longestPalindrome(String s) {
        n = s.length();
        if(n<2) return s;
        helper(s.toCharArray(), 0);
        return s.substring(x, y+1);
    }
    
    public void helper(char[] sa, int index) {
        int a=index, b=index;
        if(n==index-1 || (n-index) < (y-x+1)/2)  return;
        
        while(b<n-1 && sa[b] == sa[b+1]) {
            b++;
        }
        index=b;
        
        while(a>0 && b<n-1 && sa[a-1] == sa[b+1]) {
            a--; b++;
        }
        
        if(b-a > y-x) {
            x=a;
            y=b;
        }
        helper(sa, index+1);
    }
}