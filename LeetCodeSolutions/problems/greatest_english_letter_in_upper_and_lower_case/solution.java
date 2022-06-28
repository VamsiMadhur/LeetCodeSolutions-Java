class Solution {
    public String greatestLetter(String s) {
        boolean[] low = new boolean[26];
        boolean[] high = new boolean[26];
        for(char c : s.toCharArray()) {
            if(c >= 'A' && c<='Z') {
                high[c-'A'] = true;
            } else {
                low[c-'a'] = true;
            }
        }
        for(int i=25; i>=0; i--) {
            if(low[i] && high[i]) return "" + (char)('A'+i);
        }
        return "";
    }
}