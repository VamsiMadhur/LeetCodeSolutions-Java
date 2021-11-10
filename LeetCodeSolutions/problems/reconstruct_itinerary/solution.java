class Solution {
    HashMap<String, LinkedList<String>> graph = new HashMap<>();
    LinkedList<String> result = new LinkedList<String>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        for(List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new LinkedList<>()).add(ticket.get(1));
        }
        
        for(String key : graph.keySet()) {
            LinkedList<String> edges = graph.get(key);
            Collections.sort(edges);
        }
        
        
        dfs("JFK");
        return result;
    }
    
    public void dfs(String origin) {
        if(graph.containsKey(origin)) {
            LinkedList<String> outedges = graph.get(origin);
            while(outedges != null && !outedges.isEmpty()) {
                String dest = outedges.pollFirst();
                dfs(dest);
            }
        }
        result.offerFirst(origin);
    }
}