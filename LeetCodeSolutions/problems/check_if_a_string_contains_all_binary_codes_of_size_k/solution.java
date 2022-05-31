class Solution {
    public boolean hasAllCodes(String s, int k) {
        int maxNumbers = 1<<k;
        int mask = maxNumbers-1;
        
        char[] sa = s.toCharArray();
        int n = sa.length;
        boolean[] cache = new boolean[maxNumbers];
        
        int i=0, hashValue = 0;
        
        while(i<n) {
             hashValue = ((hashValue << 1) & mask) | (sa[i] - '0');

            if(i>= k-1 && !cache[hashValue]) {
                cache[hashValue]=true; 
                if(--maxNumbers == 0) return true;
            }
            i++;
        }
        return false;
    }
}