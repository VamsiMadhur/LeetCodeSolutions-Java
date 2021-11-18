class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++) {
            int key = nums[i]%n;
            nums[key] = nums[key]+n;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        if(nums[0] < n) result.add(n);
        for(int i=1; i<n; i++) {
            if(nums[i] <= n) {
                result.add(i);
            }
        }
        return result;
    }
}