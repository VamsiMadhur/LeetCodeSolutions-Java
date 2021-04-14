class TrieNode {
    private TrieNode[] links;
    private boolean isWord;
    
    public TrieNode() {
        links = new TrieNode[26];
    }
    
    public boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }
    
    public TrieNode get(char ch) {
        return links[ch-'a'];
    }
    
    public TrieNode[] getAllLinks() {
        return links;
    }
    
    public void put(char ch, TrieNode node) {
        links[ch-'a'] = node;
    }
    
    public void setWord() {
        isWord = true;
    }
    
    public boolean isWord() {
        return isWord;
    }
}

class WordDictionary {

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setWord();
    }
    
    public boolean searchInNode(String word, TrieNode node) {
        
        for(int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            if(currentChar == '.') {
                for(TrieNode childNode : node.getAllLinks()) {
                    if(childNode!=null) {
                        if(searchInNode(word.substring(i+1), childNode))
                            return true;
                    }
                }
                return false;
            } else {
                node = node.get(currentChar);
                if(node == null) return false;
            }
        }
        return node.isWord();
    }
    
    public boolean search(String word) {
        return searchInNode(word, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */