class Solution {
    public int countAsterisks(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length, result = 0,i=0;
        while(i<n) {
            if(sa[i] == '|') {
                while(sa[++i] != '|');
            }
            if(sa[i] == '*') result++;
            i++;
        }
        return result;
    }
}