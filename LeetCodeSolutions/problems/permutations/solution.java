class Solution {
    List<List<Integer>> result = new LinkedList<>();
    int n;
    
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        
        List<Integer> output = new ArrayList<>();
        for(int num : nums) output.add(num);
        
        backtrack(output, 0);
        return result;
    }
    
    public void backtrack(List<Integer> nums, int first) {
        if(first == n) {
            result.add(new ArrayList<>(nums));
            return;
        }
        
        for(int i=first; i<n; i++) {
            Collections.swap(nums, first, i);
            
            backtrack(nums, first+1);
            
            Collections.swap(nums, first, i);
        }
        
    }
}