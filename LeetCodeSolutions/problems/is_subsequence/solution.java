class Solution {
    public boolean isSubsequence(String s, String t) {
        if("".equals(s)) return true;
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        
        int sl = s.length();
        int tl = t.length();
        
        int i=0; 
        int j=0;
        while(j<tl) {
            if(sa[i] == ta[j]) {
                i++;
                if(i == sl) return true;
            }
            j++;
        }
        return false;
    }
}