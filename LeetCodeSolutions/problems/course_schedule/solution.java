class GNode {
    public Integer inDegrees = 0;
    public List<Integer> outNodes = new LinkedList<Integer>();
}


class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        
        Map<Integer, GNode> graph = new HashMap<>();
        
        for(int[] relation : prerequisites) {
            GNode prevCourse = graph.computeIfAbsent(relation[1], k -> new GNode());
            GNode nextCourse = graph.computeIfAbsent(relation[0], k -> new GNode());
            
            prevCourse.outNodes.add(relation[0]);
            nextCourse.inDegrees += 1;
            
        }
        
        //Start from courses that have no pre-reqs
        int totalEdges = prerequisites.length;
        // Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> noDependentCourses = new LinkedList<Integer>();
        for(Map.Entry<Integer, GNode> entry : graph.entrySet()) {
            GNode node = entry.getValue();
            if(node.inDegrees == 0) {
                // if(visited.add(entry.getKey()))
                    noDependentCourses.add(entry.getKey());
            }
        }
        
        
        int removedEdges = 0;
        while(noDependentCourses.size() > 0) {
            Integer course = noDependentCourses.pop();
            for(Integer nextCourse : graph.get(course).outNodes) {
                
                GNode childNode = graph.get(nextCourse);
                childNode.inDegrees -= 1;
                removedEdges += 1;
                if(childNode.inDegrees == 0)
                    noDependentCourses.add(nextCourse);
            }
        }
        
        if(removedEdges != totalEdges)
            return false;
        else
            return true;
    }
}