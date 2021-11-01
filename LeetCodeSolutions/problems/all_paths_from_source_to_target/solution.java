class Solution {
    
    List<List<Integer>> result;
    int n=0;
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        result = new ArrayList<>();
        dfs(graph, 0, new LinkedList<Integer>());
        return result;
    }
    
    
    public void dfs(int[][] graph, int node, LinkedList<Integer> temp) {
        if(node == n-1) {
            temp.addLast(node);
            result.add(new ArrayList<>(temp));
            temp.removeLast();
        }
        temp.addLast(node);
        int[] adj = graph[node];
        for(int a : adj) {
            dfs(graph, a, temp);
        }
        temp.removeLast();
    }
}