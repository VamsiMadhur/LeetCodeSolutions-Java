class TrieNode {
    TrieNode[] child = new TrieNode[26];
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        
        Arrays.sort(words, (a, b)->(b.length()-a.length()));
        int result = 0;
        
        for(String word : words) {
            if(insert(word.toCharArray(), root)) {
                result+= word.length()+1;
            }
        }
        return result;
    }
    
    public boolean insert(char[] word, TrieNode root) {
        boolean isNew = false;
        for(int i=word.length-1; i>=0; i--) {
            int index = word[i]-'a';
            if(root.child[index] == null) {
                isNew = true;
                root.child[index] = new TrieNode();
            }
            root = root.child[index];
        }
        return isNew;
    }
}