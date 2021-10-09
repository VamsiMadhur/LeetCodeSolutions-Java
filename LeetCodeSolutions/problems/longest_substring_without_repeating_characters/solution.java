class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sa = s.toCharArray();
        int[] cache = new int[128];

        int start = 0;
        int result = 0;
        for(int i=0; i<sa.length; i++) {
            if(cache[sa[i]] != 0) {
                start = Math.max(start, cache[sa[i]]);
            }
            result = Math.max(result, i-start+1);
            cache[sa[i]] = i+1;
        }
        return result;
    }
}