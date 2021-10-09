class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] cache = new int[26];
        for(char c : s.toCharArray()) {
            cache[c - 'a'] ++;
        }
        
        for(char c : t.toCharArray()) {
            if(--cache[c - 'a'] < 0) return false;
        }
        return true;
    }
}