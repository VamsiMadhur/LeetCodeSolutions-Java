class TrieNode {
    Map<Character, TrieNode> child = null;
    String word = null;
    
    TrieNode() {
        child = new HashMap<>();
    }
}

class Solution {
    int m=0, n=0;
    TrieNode root;
    char[][] board;
    Set<String> result = new HashSet<>();
    
    public void populateInTrie(String[] words) {
        for(String wordString : words) {
            char[] word = wordString.toCharArray();
            TrieNode curr = root;
            
            if(checkIfNecessary(word)) {
                for(int i=0; i<word.length; i++) {
                    char ch = word[i];
                    curr = curr.child.computeIfAbsent(ch, k -> new TrieNode());
                }
            }
            curr.word = wordString;
        }
    }
    
    public boolean checkIfNecessary(char[] word) {
        if(word.length > m*n) return false;
        
        for(int k=0; k<word.length; k++) {
            boolean temp = false;
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(word[k] == board[i][j]) {
                        temp = true;
                        break;
                    }
                }
                if(temp) break;
            }
            if(!temp) return false;
        }
        return true;
    }
    
    public void dfs(TrieNode curr, int i, int j) {
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] == '#') return;
        
        char letter = board[i][j];
        curr = curr.child.get(letter);
        if(curr == null) return;
        
        if(curr.word != null) {
            result.add(curr.word);
        }
        
        board[i][j] = '#';
        dfs(curr, i+1, j);
        dfs(curr, i-1, j);
        dfs(curr, i, j+1);
        dfs(curr, i, j-1);
        board[i][j] = letter;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        
        root = new TrieNode();
        
        populateInTrie(words);
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(root.child.containsKey(board[i][j])) {
                    dfs(root, i, j);
                }
            }
        }
        return new ArrayList<>(result);
        // return result;
    }
}