class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        
        int[] cache = new int[26];
        for(char c : magazine.toCharArray()) {
            cache[c - 'a']++;
        }
        
        for(char c : ransomNote.toCharArray()) {
            if(cache[c-'a'] < 1) return false;
            cache[c - 'a']--;
        }
        return true;
    }
}