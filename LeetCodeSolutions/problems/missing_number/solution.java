class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 1) {
            return 1 - nums[0];
        }
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if((nums[i]%(n+1))!=n) {
                int key = nums[i]%(n+1);
                nums[key] = nums[key]+n+1;
            }
        }
        
        int missing = n;
        for(int i=0; i<n; i++) {
            if(nums[i] <= n) missing = i;
        }
        return missing;
    }
}