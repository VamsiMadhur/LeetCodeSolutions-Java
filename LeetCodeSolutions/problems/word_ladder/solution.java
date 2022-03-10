class Solution {
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
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        int n = wordList.size();
        
        Queue<String> queue = new LinkedList<>();
        int size = 0;
        int count = 2;
        
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
           
        for(int i=0; i<n; i++) {
            String a = wordList.get(i);
            if(isAdjacent(a.toCharArray(), beginWord.toCharArray())) {
                if(a.equals(endWord)) return count;
                queue.add(a);
                visited.add(a);
                size++;
            }
                
            for(int j=i+1; j<n; j++) {
                String b = wordList.get(j);
                if(isAdjacent(a.toCharArray(), b.toCharArray())) {
                    graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                    graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
                }
            }
        }
            
        while(!queue.isEmpty()) {
            int nextSize = 0;
            count++;
            for(int i=0; i<size; i++) {
                String temp = queue.poll();
                List<String> adjacentList = graph.getOrDefault(temp, new ArrayList<>());

                if(adjacentList.contains(endWord)) return count;
                for(String word : adjacentList) {
                    if(!visited.contains(word)) {
                        queue.add(word);
                        nextSize++;
                        visited.add(word);
                    }
                }
            }
            size = nextSize;
        }
       return 0; 
    }
}