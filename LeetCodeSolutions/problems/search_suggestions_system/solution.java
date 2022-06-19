class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
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
            root = root.child.get(c);
            if(root == null) 
                break;
            else if(root.words.size() <= 3)
                result.add(root.words);
            else
                result.add(root.words.subList(0,3));
            
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
                 curr = curr.child.computeIfAbsent(c, k->new TrieNode());
                 curr.words.add(product);
             }
         }
    }
}