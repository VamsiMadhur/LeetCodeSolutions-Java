class Solution {

    int[] root, rank;
    
    public int countComponents(int n, int[][] edges) {
        
        root = new int[n];
        rank = new int[n];
        
        for(int i=0; i<n; i++) root[i] = i;
        
        for(int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        
        int count = 0;
        for(int i=0; i<n; i++) {
            if(root[i] == i) count++;
        }
        return count;
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
        
        if(a == b) return;
        
        if(rank[a] > rank[b]) {
            root[b] = a;
        } else {
            root[a] = b;
            if(rank[a] == rank[b]) {
                rank[b]++;
            }
        }
    }
}