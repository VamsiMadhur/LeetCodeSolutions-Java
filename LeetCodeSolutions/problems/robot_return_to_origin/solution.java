class Solution {
    public boolean judgeCircle(String moves) {
        int h = 0;
        int v = 0;
        char[] ca = moves.toCharArray();
        for(char c : ca) {
            if(c == 'U') {
                v--;
            } else if(c == 'D') {
                v++;
            } else if(c == 'L') {
                h--;
            } else if(c == 'R') {
                h++;
            }
        }
        if(h==0 && v==0) {
            return true;
        }
        return false;
    }
}