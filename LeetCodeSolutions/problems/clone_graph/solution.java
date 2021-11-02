/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> cache = new HashMap();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        cache.put(node, new Node(node.val));
        
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            
            for(Node neigh : n.neighbors) {
                if(!cache.containsKey(neigh)) {
                    cache.put(neigh, new Node(neigh.val));
                    queue.offer(neigh);
                }
                cache.get(n).neighbors.add(cache.get(neigh));
            }
        }
        return cache.get(node);
    }
}