class Solution {
    public boolean checkString(String s) {
        char[] sa = s.toCharArray();
        int i=0, n=sa.length;
        while(i<n) {
            if(sa[i++] == 'b') break;
        }
        while(i<n) {
            if(sa[i++] == 'a') return false;
        }
        return true;
    }
}