class TrieNode {
    TrieNode[] child = new TrieNode[26];
    List<Integer> indexList = new ArrayList<>();
    
}

class WordFilter {
    TrieNode root;
    String[] words;
    
    public WordFilter(String[] words) {
        root = new TrieNode();
        this.words = words;
        for(int i=0; i<words.length; i++) {
            TrieNode curr = root;
            for(char c : words[i].toCharArray()) {
                if(curr.child[c-'a'] == null) curr.child[c-'a'] = new TrieNode();
                curr.child[c-'a'].indexList.add(i);
                curr = curr.child[c-'a'];
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            curr = curr.child[c-'a'];
            if(curr == null) return -1;
        }
        
        List<Integer> list = curr.indexList;
        for(int i=list.size()-1; i>=0; i--) {
            if(words[list.get(i)].endsWith(suffix)) 
                return list.get(i);
        }
        return -1;
     }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */