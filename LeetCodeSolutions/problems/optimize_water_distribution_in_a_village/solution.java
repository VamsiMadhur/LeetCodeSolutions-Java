class Solution {

    int[] root;
    int[] rank;
    
    int count = 0;
    int cost = 0;
    
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        root = new int[n+1];
        rank = new int[n+1];
        
        for(int i=1; i<=n; i++) root[i] = i;
        
        List<int[]> edges = new ArrayList<>(pipes.length+n);
        
        for(int[] pipe : pipes) {
            edges.add(pipe);
        }
        for(int i=1; i<=n; i++) {
            edges.add(new int[]{0, i, wells[i-1]});
        }
        
        Collections.sort(edges, (a,b) -> (a[2]-b[2]));
        
        for(int[] edge : edges) {
            union(edge[0], edge[1], edge[2]);
            if(count == n) break;
        }
        
        return cost;
    }
    
    public int find(int x) {
        if(x != root[x]) {
            x = find(root[x]);
        }
        return root[x];
    }
    
    public void union(int x, int y, int pipeCost) {
        int a = find(x);
        int b = find(y);
        
        if(a == b) return;
        
        if(rank[a] < rank[b]) {
            root[a] = b;
        } else {
            root[b] = a;
            if(rank[a] == rank[b]) rank[a]++;
        }
        cost += pipeCost;
        count++;
        
    }
}