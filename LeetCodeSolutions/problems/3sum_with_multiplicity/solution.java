class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        int[] cache = new int[101];
        int unique = 0;
        for(int num : arr) {
            cache[num]++;
            if(cache[num] == 1) unique ++;
        }
        int[] keys = new int[unique];
        int index=0;
        for(int i=0; i<=100; i++) {
            if(cache[i] > 0) keys[index++] = i;
        }
        
        long count = 0;
        for(int ip=0; ip<unique; ip++) {
            int i = keys[ip];
            int m = cache[i];
            if(m >= 3 && (3*i) == target) {
                long temp = m * (m-1) / 2;
                count += temp * (m-2) / 3;
            }
            for(int jp=ip+1; jp<unique; jp++) {
                int j = keys[jp];
                int n = cache[j];
                if(m >= 2 && (2*i + j) == target) {
                    count += (m * (m-1))/2 * n; 
                }
                if(n >= 2 && (i + 2*j) == target) {
                    count += (n * (n-1))/2 * m;
                }
                
                int k = target - i - j;
                if(k<0 || k>100 || k<=j) continue;
                int p = cache[k];
                count += (m * n * p);
            }
        }
        count %= MOD;
        return (int)count;
            
    }
}