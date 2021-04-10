class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        for(char c : s.toCharArray()) {
            if(c == 'A') {
                a++;
                if(a==2) {
                    return false;
                }
                l=0;
            } else if(c == 'L') {
                l++;
                if(l==3) {
                    return false;
                }
            } else {
                l=0;
            }
        }
        return true;
        
    }
}