class GNode {
    String key;
    List<String> adjacentList;
    Set<String> parentKey;
    
    GNode(String key) {
        this.key = key;
        this.adjacentList = new ArrayList<>();
        this.parentKey = new HashSet<>();
    }
}

class Solution {
    List<List<String>> result = new LinkedList<>();
    
    public boolean isAdjacent(char[] a, char[] b ) {
        int differ= 0;
        for(int i=0; i<a.length; i++) {
            if(a[i] != b[i]) {
                differ++;
                if(differ == 2) return false;
            }
        }
        return true;
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return result;
        
        int n = wordList.size();
        
        Queue<String> queue = new LinkedList<>();
        int size = 0;
        
        
        Map<String, GNode> graph = new HashMap<>();
        
        Set<String> visited = new HashSet<>();
        
        for(String word : wordList) graph.put(word, new GNode(word));
        
        int count = 2;
        
        for(int i=0; i<n; i++) {
            String a = wordList.get(i);
            
            if(isAdjacent(a.toCharArray(), beginWord.toCharArray())) {
                if(a.equals(endWord)) {
                    List<String> temp = new ArrayList<>();
                    temp.add(beginWord);
                    temp.add(endWord);
                    result.add(temp);
                    return result;
                }
                
                graph.get(a).parentKey.add(beginWord);
                queue.add(a);
                visited.add(a);
                size++;
            }
                
            for(int j=i+1; j<n; j++) {
                String b = wordList.get(j);
                if(isAdjacent(a.toCharArray(), b.toCharArray())) {
                    graph.get(a).adjacentList.add(b);
                    graph.get(b).adjacentList.add(a);
                }
            }
        }
        
            
        boolean returnFlag = false;
        List<String> finalExits = new ArrayList<>();
        
        while(!returnFlag && !queue.isEmpty()) {
            int nextSize = 0;
            count++;
            Set<String> currVisited = new HashSet<>();
            for(int i=0; i<size; i++) {
                String temp = queue.poll();
                
                List<String> adjacentList = graph.get(temp).adjacentList;

                if(adjacentList.contains(endWord)) {
                    graph.get(endWord).parentKey.add(temp);
                    returnFlag = true;
                }
                
                for(String word : adjacentList) {
                    if(!visited.contains(word)) {
                            queue.add(word);
                            graph.get(word).parentKey.add(temp);
                            nextSize++;
                            currVisited.add(word);
                    }
                }
            }
            visited.addAll(currVisited);
            size = nextSize;
        }
        
        LinkedList<String> temp = new LinkedList<>();
        temp.addFirst(endWord);
        print(beginWord, endWord, graph, temp);
        return result;
    }
    public void print(String beginWord, String endWord, Map<String, GNode> graph, LinkedList<String> curr) {
        if(endWord.equals(beginWord)) {
            result.add((LinkedList)curr.clone());
        } else {
            Set<String> parentKey = graph.get(endWord).parentKey;
            for(String key : parentKey) {
                curr.addFirst(key);
                print(beginWord, key, graph, curr);
                curr.removeFirst();
            }
        }
    }
}
