class TrieNode {
    TrieNode[] child = new TrieNode[26];
    List<String> words = new ArrayList<>();
}
class Solution {
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        root = new TrieNode();
        populateInTrie(products);
        char[] search = searchWord.toCharArray();
        int currSize = 0, n=search.length;
        for(char c : search) {
            root = root.child[c-'a'];
            if(root == null) 
                break;
            result.add(root.words);
            currSize++;
        }
        for(int i=currSize; i<n; i++) 
            result.add(new ArrayList<>());
        return result;
    }
    
    public void populateInTrie(String[] products) {
         for(String product : products) {
            char[] word = product.toCharArray();
            TrieNode curr = root;
             
             for(char c : word) {
                 if(curr.child[c-'a'] == null) 
                     curr.child[c-'a'] = new TrieNode();
                 curr = curr.child[c-'a'];
                 if(curr.words.size() < 3)
                    curr.words.add(product);
             }
         }
    }
}