class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 10000000;
        int[][] cache = new int[2][n];
        
        Arrays.fill(cache[0], INF);
        Arrays.fill(cache[1], INF);
        cache[0][src] = 0;
        cache[1][src] = 0;
        
        int prev = 0;
        int curr = 1;
        
        for(int i=0; i<=k; i++) {
            for(int[] edge : flights) {
                cache[curr][edge[1]] = Math.min(cache[curr][edge[1]], cache[prev][edge[0]] + edge[2]);
            }
            prev ^= 1;
            curr ^= 1;
        }
        return cache[prev][dst]==INF? -1 : cache[prev][dst];
     }
}