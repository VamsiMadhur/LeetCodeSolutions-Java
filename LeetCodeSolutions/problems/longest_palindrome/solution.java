class Solution {
    public int longestPalindrome(String s) {
        int[] cache = new int[128];
        for(char c:s.toCharArray()) cache[c]++;
        
        int even=0, odd=0;
        for(int num: cache) {
            if((num&1)==0) even+=num;
            else {
                even+=num-1;
                odd=1;
            }
        }
        return even+odd;
    }
}