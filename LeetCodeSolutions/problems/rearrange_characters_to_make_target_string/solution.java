class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] cache = new int[26];
        for(char c : target.toCharArray()) cache[c-'a'] += 1;
        
        int[] sa = new int[26];
        for(char c : s.toCharArray()) sa[c-'a'] += 1;
        
        int max = 100;
        for(char c : target.toCharArray()) {
            if(sa[c-'a'] == 0) return 0;
            int temp = sa[c-'a']/cache[c-'a'];
            max = Math.min(temp, max);
        }
        return max;
        
    }
}