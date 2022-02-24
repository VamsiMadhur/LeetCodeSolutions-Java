class Solution {
    int[] root;
    int[] rank;
    int count=0;
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        rank = new int[m*n];
        root = new int[m*n];
        
        List<Integer> result = new ArrayList<>(positions.length);
        
        boolean [] isLand = new boolean[m*n];
        
        for(int i=0; i<(m*n); i++) root[i] = -1;
        
        for(int[] position : positions) {
            int i = position[0];
            int j = position[1];
            
            int idx = j + i*n;
            if(!isLand[idx]) {
                isLand[idx] = true;
                root[idx] = idx;
                count++;

                int west = j-1 + i*n;
                int east = j+1 + i*n;
                int north = j + (i-1)*n;
                int south = j + (i+1)*n;

                if(j>0 && isLand[west]) union(west, idx);
                if(j<n-1 && isLand[east]) union(east, idx);
                if(i>0 && isLand[north])  union(north, idx);
                if(i<m-1 && isLand[south]) union(south, idx);
            }
            
            result.add(count);
        }
        return result;   
    }
    public int find(int x) {
        if(x != root[x])
            x = find(root[x]);
        return x;
    }
    
    public void union(int p1, int p2) {
        int a = find(p1);
        int b = find(p2);
        
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