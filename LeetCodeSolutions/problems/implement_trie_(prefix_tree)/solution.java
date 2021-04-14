class TrieNode {
    
    public TrieNode[] links;
    
    public boolean isEnd;
    
    public TrieNode() {
        links = new TrieNode[26];
    }
}


class Trie {

    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            TrieNode temp = node.links[currentChar-'a'];
            if(temp == null) {
                temp = new TrieNode();
                node.links[currentChar-'a'] = temp;
            }
            node = temp;
        }
        node.isEnd = true;
    }
    
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            node = node.links[currentChar-'a'];
            if(node == null) return null;
        }
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node!=null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */