class GNode {
    int inDegree = 0;
    List<Integer> outEdges = new ArrayList<>();
}

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, GNode> graph = new HashMap<>();
        for(int i=1; i<=n; i++) {
            graph.put(i, new GNode());
        }
        
        for(int[] relation : relations) {
            GNode prev = graph.get(relation[0]);
            GNode next = graph.get(relation[1]);
            next.inDegree++;
            prev.outEdges.add(relation[1]);
        }
        
        
        Integer[] result = new Integer[n];
        int index = 0;
        for(int i=1; i<=n; i++) {
            GNode course = graph.get(i);
            if(course.inDegree == 0) {
                result[index++] = i;
            }
        }
        int answer = 1;
        int i=0;
        int size = index;
        while(i<index) {
            int nextSize = 0;
            for(int j=0; j<size; j++) {
                Integer prevCourse = result[i++];
                GNode prevC = graph.get(prevCourse);
                for(Integer outedge : prevC.outEdges) {
                    GNode nextCourse = graph.get(outedge);
                    nextCourse.inDegree--;
                    if(nextCourse.inDegree == 0) {
                        result[index++] = outedge;
                        nextSize++;
                    }
                }
            }
            answer++;
            size = nextSize;
        }
        if(index != n) return -1;
        else return answer-1;
    }
}