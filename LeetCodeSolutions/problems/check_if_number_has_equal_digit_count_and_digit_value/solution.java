class Solution {
    public boolean digitCount(String num) {
        int[] cache = new int[10];
        char[] na = num.toCharArray();
        for(char c : na) cache[c-'0']++;
        
        for(int i=0; i<na.length; i++) {
            if((na[i]-'0') != cache[i]) return false;
        }
        return true;
        
    }
}