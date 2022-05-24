class Solution {
    public int longestValidParentheses(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length, result=0;
        int i=0, open=0, closed=0;
        
        while(i<n && sa[i]==')') i++;
        while(i<n) {
            if(sa[i] == '(') open++;
            else closed++;
            if(open == closed) {
                result = Math.max(result, 2*open);
            } else if(open < closed) {
                open=0; 
                closed=0;
            }
            i++;
        }
        
        i=n-1; open = 0; closed=0;
        while(i>=0 && sa[i] == '(') i--;
        while(i>=0) {
            if(sa[i] == ')') closed++;
            else open++;
            if(open == closed) {
                result = Math.max(result, 2*open);
            } else if(closed < open) {
                open=0; 
                closed = 0;
            }
            i--;
        }
        return result;
    }
}