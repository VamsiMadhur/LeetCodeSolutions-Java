class Solution {
    int[] root;
    int[] rank;
        
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        root = new int[n+1];
        rank = new int[n+1];
        
        List<Boolean> result = new ArrayList<>();
        if(threshold == 0) {
            for(int[] query : queries) result.add(true);
            return result;
        }
        
        for(int i=1; i<=n; i++) root[i] = i;
        for(int i=threshold+1; i<=n; i++) {
            boolean first = false;
            int j = 2;
            while(j*i <= n) {
                first = true;
                union(i, (i*j));
                j++;
            }
            if(!first) break;
        }
        
        
        int i=0;
        for(int[] query : queries) {
            if(find(query[0]) == find(query[1])) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
        
    }
    
    public int find(int x) {
        if(x != root[x])
            x = find(root[x]);
        return x;
    }
    
    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a == b) return;
        
        if(rank[a] > rank[b]) {
            root[b] = a;
        } else {
            root[a] = b;
            if(rank[a] == rank[b]) 
                rank[b]++;
        }
    }
}