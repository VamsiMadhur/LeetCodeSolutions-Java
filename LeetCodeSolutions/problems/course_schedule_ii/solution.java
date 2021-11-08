class Node {
    int inDegree = 0;
    List<Integer> outEdges = new ArrayList<>();
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, Node> graph = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            graph.put(i, new Node());
        }
        
        for(int[] prereq : prerequisites) {
            Node first = graph.get(prereq[0]);
            Node second = graph.get(prereq[1]);
            
            first.inDegree++;
            second.outEdges.add(prereq[0]);
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        for(int i=0; i<numCourses; i++) {
            Node node = graph.get(i);
            if(node.inDegree == 0) {
                result[index++] = i;
            }        
        }
        
        int i=0;
        int removedEdges = 0;
        int totalEdges = prerequisites.length;
        while(i < index) {
            int course = result[i];
            Node n = graph.get(course);
            
            for(int child : n.outEdges) {
                Node childNode = graph.get(child);
                childNode.inDegree--;
                removedEdges++;
                if(childNode.inDegree == 0) {
                    result[index++] = child;
                }
            }
            i++;
        }
        if(totalEdges == removedEdges) {
            return result;
        } else {
            return new int[0];
        }
        
    }
}