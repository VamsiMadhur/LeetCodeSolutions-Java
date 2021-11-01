class Solution {

    int[] root, rank;
    
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;
        
        root = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++) root[i] = i;
        
        for(int[] edge : edges) {
            union(edge[0], edge[1]);
            if((edge[0]==start || edge[1] == start || edge[0] == end || edge[1] == end) && (isConnected(start, end))) return true;
        }
        return isConnected(start, end);
    }
    
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
    
    public int find(int x) {
        if(x != root[x]) {
            x = find(root[x]);
        }
        return root[x];
    }
    
    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(rank[a] > rank[b]) {
            root[b] = a;
        } else {
            root[a] = b;
            if(rank[a] == rank[b]) rank[b]++;
        }
    }
    
    
}