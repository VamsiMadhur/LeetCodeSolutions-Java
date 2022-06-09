class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int result = n/2;
        boolean[] cache = new boolean[n];
        cache[0] = true;
        cache[1] = true;
        for(int i=3; i*i < n; i=i+2) {
            if(cache[i]) continue;
            
            for(int j=i*i; j<n; j+=(i<<1)) {
                if(!cache[j]) {
                    result--;
                    cache[j] = true;
                }
            }
        }
        return result;
    }
}