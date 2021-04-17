class GNode {
    public int inDegree = 0;
    public List<Integer> outNodes = new ArrayList<>();
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, GNode> graph = new HashMap<>();
        for(int[] relation : prerequisites) {
            GNode prevNode = graph.computeIfAbsent(relation[1], k -> new GNode());
            GNode nextNode = graph.computeIfAbsent(relation[0], k -> new GNode());
            
            prevNode.outNodes.add(relation[0]);
            nextNode.inDegree += 1;
        }
        
        int[] rootCourses = new int[numCourses];
        int size = 0;
        for(int j=0; j<numCourses; j++) {
            GNode node = graph.computeIfAbsent(j, k -> new GNode());
            if(node.inDegree == 0) {
                rootCourses[size++] = j;
            }
        }
        
        int i=0;
        int removedEdges = 0;
        int totalEdges = prerequisites.length;
        while(i<size) {
            Integer course = rootCourses[i];
            
            for(Integer nextCourse : graph.get(course).outNodes) {
                
                GNode childNode = graph.get(nextCourse);
                childNode.inDegree -= 1;
                removedEdges += 1;
                if(childNode.inDegree == 0) {
                    rootCourses[size++] = nextCourse;
                }
            }
            i++;
        }
        
        if(totalEdges != removedEdges) {
            return new int[0];
        } else {
            return rootCourses;
        }
        
    }
}