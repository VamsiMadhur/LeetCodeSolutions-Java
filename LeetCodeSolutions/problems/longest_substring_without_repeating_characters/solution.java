class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        char[] sa = s.toCharArray();
        int[] cache = new int[128];
        int result=1, n=sa.length, i=0, start=0;
        while(i<n) {
            if(cache[sa[i]] != 0) {
                start = Math.max(start, cache[sa[i]]);
            }    
            result = Math.max(result, i-start+1);
            cache[sa[i]] =  i+1;
            i++;
        }
        return result;
    }
}