class Solution {
    
    List<String> result = new LinkedList<String>();
    StringBuilder path = new StringBuilder();
    
    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0);
        return result;
    }
    
    public void backtracking(int n, int open, int close) {
        if(path.length() == (n<<1)) {
            result.add(path.toString());
            return;
        }
        if(open < n) {
            path.append("(");
            backtracking(n, open+1, close);
            path.deleteCharAt(path.length()-1);
            
        }
        
        if(close < open) {
            path.append(")");
            backtracking(n, open, close+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}