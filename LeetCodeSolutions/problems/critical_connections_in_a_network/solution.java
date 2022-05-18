class Solution {
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer>[] adjacencyList = new ArrayList[n];
        for(List<Integer> connection : connections) {
            int x = connection.get(0);
            int y = connection.get(1);
            if(adjacencyList[x] == null) adjacencyList[x] = new ArrayList<>();
            if(adjacencyList[y] == null) adjacencyList[y] = new ArrayList<>();
            adjacencyList[x].add(y);
            adjacencyList[y].add(x);
        }
        
        int[] nodeRanks = new int[n];        
        dfs(0, -1, 1, nodeRanks, adjacencyList, result);
        
        return result;
    }
    
    public void dfs(int currNode, int parentNode, int curRank, int[] nodeRanks, List<Integer>[] adjacencyList, List<List<Integer>> result) {
        
       nodeRanks[currNode] = curRank;
        
        for(int neighbour : adjacencyList[currNode]) {
            if(neighbour == parentNode) continue;
            
            if(nodeRanks[neighbour] == 0)  
                dfs(neighbour, currNode, curRank+1, nodeRanks, adjacencyList, result);
            
            if(nodeRanks[neighbour] > curRank) {
                result.add(Arrays.asList(currNode, neighbour));
            } else {
                nodeRanks[currNode] = Math.min(nodeRanks[currNode], nodeRanks[neighbour]);
            }
        }
    }
}