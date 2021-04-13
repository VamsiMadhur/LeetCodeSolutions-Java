class Solution {
    public int countSegments(String s) {
        
        int len = s.length();
        
        if(len==0) return 0;
        
        int cnt=0;
         for (int i = 0; i < len; i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                cnt++;
            }
        }
        return cnt;
    }
}