class GNode {
    int inDegree = 0;
    List<Integer> outEdges = new ArrayList<>();
    int st = 0;
    int ft = 0;
}



class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, GNode> graph = new HashMap<>();
        for(int i=1; i<=n; i++) {
            graph.put(i, new GNode());
        }
        
        for(int[] relation : relations) {
            GNode prev = graph.get(relation[0]);
            GNode curr = graph.get(relation[1]);
            
            prev.outEdges.add(relation[1]);
            curr.inDegree++;
        }
        
        int[] result = new int[n];
        int index = 0;
        int answer = 0;
         for(int i=1; i<=n; i++) {
             GNode curr = graph.get(i);
             if(curr.inDegree == 0) {
                 result[index++] = i;
                 curr.st = 0;
                 curr.ft = curr.st + time[i-1];
                 answer = Math.max(answer, curr.ft);
                 for(Integer child: curr.outEdges) {
                     GNode childNode = graph.get(child);
                     childNode.st = Math.max(childNode.st, curr.ft);
                 }
             }
        }
        
        int i=0;
        while(i < index) {
            GNode curr = graph.get(result[i]);
            for(Integer child : curr.outEdges) {
                GNode childNode = graph.get(child);
                childNode.inDegree--;
                if(childNode.inDegree == 0) {
                    result[index++] = child;
                    childNode.ft = childNode.st + time[child-1];
                    answer = Math.max(answer, childNode.ft);
                    for(Integer gchild: childNode.outEdges) {
                        GNode gchildNode = graph.get(gchild);
                        gchildNode.st = Math.max(gchildNode.st, childNode.ft);
                    }
                }
            }
            i++;
        }
        return answer;
    }
}