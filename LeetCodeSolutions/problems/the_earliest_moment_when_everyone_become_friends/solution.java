class Solution {
    
    int[] root;
    int[] rank;
    int count = 0;
    public int earliestAcq(int[][] logs, int n) {
        
        count = n;
        root = new int[n];
        rank = new int[n];
        
        Arrays.sort(logs, (a,b) -> (a[0] - b[0]));
        for(int i=0; i<n; i++) root[i] = i;
        
        for(int[] log : logs) {
            union(log[1], log[2]);
            if(count == 1) return log[0];
        }
        return -1;
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
            if(rank[a] == rank[b]) rank[b]++;
        }
        count--;
    }
    
}