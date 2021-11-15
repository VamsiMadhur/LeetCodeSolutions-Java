class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if(n < 2) {
            List<Integer> result = new ArrayList<>();
            for(int i=0; i<n; i++) result.add(i);
            return result;
        }
        
        List<Integer>[] outedges = new List[n];
        
        for(int i=0; i<n; i++) outedges[i] = new ArrayList<>();
        
        for(int[] edge: edges) {
            int a = edge[0], b = edge[1];
            outedges[a].add(b);
            outedges[b].add(a);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(outedges[i].size() == 1) leaves.add(i);
        }
            
        int remainingNodes = n;
        while(remainingNodes > 2) {
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for(Integer leaf : leaves) {
                List<Integer> neighbors = outedges[leaf];
                for(Integer neighbor : neighbors) {
                    outedges[neighbor].remove(leaf);
                    if(outedges[neighbor].size() == 1) 
                        newLeaves.add(neighbor);
                }
            }
            leaves.clear();
            leaves.addAll(newLeaves);
        }
        return leaves;
    }
}