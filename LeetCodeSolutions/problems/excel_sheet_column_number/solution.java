class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int val = 1;
        for(int i=s.length()-1; i>=0; i--) {
            int curr = s.charAt(i) -'A'+1;
            result+=(val*curr); 
            val*=26;
        }
        return result;
    }
}