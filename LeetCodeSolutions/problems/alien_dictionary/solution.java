class GNode {
    public int inDegree = 0;
    public List<Character> outNodes = new ArrayList<>();
}

class Solution {
    
    public String alienOrder(String[] words) {
        Map<Character, GNode> graph = new HashMap<>();
        
        //Get All GNodes for all letters
        for(String word : words) {
            for(char c : word.toCharArray()) {
                graph.computeIfAbsent(c, k-> new GNode());
            }
        }
        //buildGraph(graph, words);
        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
            
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++) {
                char prev = word1.charAt(j);
                char next = word2.charAt(j);
                if(prev != next) {
                    GNode prevNode = graph.get(prev);
                    GNode nextNode = graph.get(next);
                    prevNode.outNodes.add(next);
                    nextNode.inDegree++;
                    break;
                }
            }
        }
        
        char[] result = new char[graph.size()];
        int size = 0;
        
        for(Map.Entry<Character, GNode> entry : graph.entrySet()) {
            if(entry.getValue().inDegree == 0) {
                result[size++] = entry.getKey();
            }
        }
        
        int i=0;
        while(i<size) {
            char temp = result[i++];
            GNode currNode = graph.get(temp);
            for(Character outNode : currNode.outNodes) {
                GNode nextNode = graph.get(outNode);
                nextNode.inDegree--;
                if(nextNode.inDegree == 0) {
                    result[size++] = outNode;
                }
            } 
        }
        
        if(size == graph.size()) {
            return new String(result);
        } else {
            return "";
        }
    }
}