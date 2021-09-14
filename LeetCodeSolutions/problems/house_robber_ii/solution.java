class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        return Math.max(rob(nums, 0), rob(nums, 1));
    }
    
    public int rob(int[] nums, int low) {
        int n = nums.length;
        
        int a = 0;
        int b = nums[low];
        
        for(int i=1; i<n-1; i++) {
            int temp = Math.max(b, a+nums[low+i]);
            a = b;
            b = temp;
        }
        return Math.max(a,b);
     }
}