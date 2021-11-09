class GNode {
    int inDegree = 0;
    List<Character> outedges = new ArrayList<>();
}

class Solution {
    public String alienOrder(String[] words) {
        
        int n = words.length;
        
        Map<Character, GNode> graph = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.computeIfAbsent(c, k -> new GNode());
            } 
        }
        
        for(int i=0; i<n-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)) 
                return "";
            if(word2.length() > word1.length() && word1.startsWith(word2)) 
                continue;
            
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2) {
                    graph.get(c2).inDegree++;
                    graph.get(c1).outedges.add(c2);
                    break;
                }
            }
        }
        
        char result[] = new char[graph.size()];
        int index = 0;
        for(Map.Entry<Character,GNode> entry : graph.entrySet()) {
            if(entry.getValue().inDegree == 0) {
                result[index++] = entry.getKey();
            }
        }
        
        int i=0;
        while(i<index) {
            char curr = result[i++];
            GNode curNode = graph.get(curr);
            for(Character child : curNode.outedges) {
                GNode childNode = graph.get(child);
                childNode.inDegree --;
                if(childNode.inDegree == 0) {
                    result[index++] = child;
                }
            }
        }
        
        if(index == graph.size()) {
            return new String(result);
        } else {
            return "";
        }
        
    }
}