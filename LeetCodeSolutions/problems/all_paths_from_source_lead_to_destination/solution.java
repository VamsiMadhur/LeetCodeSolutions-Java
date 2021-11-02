class Solution {
    
    boolean[] visited;
    int dest = 0;
    List<Integer>[] edgesList;
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        dest = destination;
        
        edgesList = new List[n];
        for(int i=0; i<n; i++) {
            edgesList[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            edgesList[edge[0]].add(edge[1]);
        }
        
        if(edgesList[destination].size() != 0) return false;
        
        
        return traversal(source);
    }
    
    // 0:true, 1:cycle, infinite 2:no way
    public boolean traversal(int source) {
        // if(source == dest) return true;
        if(source!=dest && edgesList[source].size() == 0) return false;
        
        visited[source] = true;
        for(int adj : edgesList[source]) {
            if(visited[adj]) return false;
            
            boolean temp = traversal(adj);
            if(!temp) return false;
        }
        visited[source] = false;
        return true;
    }
}