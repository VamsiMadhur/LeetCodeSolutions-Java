class Solution {
    public boolean validTree(int n, int[][] edges) {
       
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        while(!stack.isEmpty()) {
            Integer node = stack.pop();
            
            for(Integer neighbor : adjList.get(node)) {
                if(visited.contains(neighbor)) return false;
                
                stack.push(neighbor);
                visited.add(neighbor);
                
                adjList.get(neighbor).remove(node);
            }
        }
        
        
        return visited.size()==n;
    }
}