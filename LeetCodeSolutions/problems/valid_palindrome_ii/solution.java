class Solution {
    boolean skip = false;
    char[] sa;
    int n;
    public boolean validPalindrome(String s) {
        n = s.length();
        sa = s.toCharArray();
        if(n <= 1) return true;
        
        int i=0, j=n-1;
        while(i<j) {
            if(sa[i] != sa[j]) {
                return checkPalindrome(i, j-1) || checkPalindrome(i+1, j);
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean checkPalindrome(int low, int high) {
        
        while(low < high) {
            if(sa[low] != sa[high]) return false;
            low++;
            high--;
        }
        return true;
        
    }
}