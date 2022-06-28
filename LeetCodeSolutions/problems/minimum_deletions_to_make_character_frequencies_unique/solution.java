class Solution {
    public int minDeletions(String s) {
        int[] cache = new int[26];
        for(char c:s.toCharArray()) cache[c-'a']++;

        Arrays.sort(cache);
        
        int result = 0, nextAllowed=cache[25]-1;
        for(int i=24; i>=0; i--) {
            if(cache[i] == 0) break;
            else if(nextAllowed == 0) result += cache[i];
            else if(cache[i] > nextAllowed) {
                result += cache[i]-nextAllowed;
                cache[i] = nextAllowed;
                nextAllowed--;
            } else {
                nextAllowed = cache[i]-1;
            }
        }
        return result;
        
    }
}