class Solution {
    
    int[] root;
    int[] rank;
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        root = new int[n];
        rank = new int[n];
        
        //intialize
        for(int i=0; i<n; i++) {
            root[i] = i;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1 && i!=j) {
                    union(i, j);
                }
            }
        }
        
        //final count
        int count=0;
        for(int i=0; i<n; i++) {
            if(root[i] == i) count++;
        }
        
        return count;
    }
    
    public int find(int x) {
        if(x != root[x]) {
            root[x] = find(root[x]);
        }
        return root[x];
    }
    
    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        
        if(a == b) return;
         
        if(rank[a] > rank[b]) {
            root[a] = b;
        } else {
            root[b] = a;
            if(rank[b] == rank[a]) {
                rank[a]++;
            }
        }
    }
}