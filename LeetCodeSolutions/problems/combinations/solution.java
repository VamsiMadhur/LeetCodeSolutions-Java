class Solution {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(new LinkedList<>(), 1, n, k);
        return result;
    }
        
        
    public void backtrack(LinkedList<Integer> stack, int low, int high, int k) {
        if(k == 0) {
            result.add(new LinkedList(stack));
            return;
        }
        
        for(int i = low; i<= high-k+1; i++) {
            stack.add(i);
            backtrack(stack, i+1, high, k-1);
            stack.removeLast();
        }
    }
}