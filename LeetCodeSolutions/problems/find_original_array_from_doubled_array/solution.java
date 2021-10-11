class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n % 2 == 1) return new int[0];
        
        int max = 0;
        for(int x : changed) {
            max = Math.max(max, x);
        }
        
        int[] cache = new int[max+1];
        for(int x : changed) {
            cache[x]++;
        }
        
        
        int[] result = new int[n>>1];
        
        if(cache[0]%2 == 1) return new int[0];
        int idx = cache[0]/2;
        
       for(int i=1; i<=max; i++) {
           if(cache[i] > 0) {
               int c = i;
               int w = c<<1;
               
               if(w>max) return new int[0];
               if(cache[c] > cache[w]) {
                   return new int[0];
               } else {
                 int m = cache[i];
                  for(int j=0; j<m; j++) {
                      result[idx++] = c;
                  }
                   cache[w] -= m;
                   if(idx == n) return result;
               }
           }
       }
        return result;
    }
}