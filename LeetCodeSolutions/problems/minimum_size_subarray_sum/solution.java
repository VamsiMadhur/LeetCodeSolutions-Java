class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int init = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum >= target) {
                while(sum >= target) {
                     sum = sum - nums[init];
                    result = Math.min(result, (i-init+1));
                    init++;
                }
            } 
        }
        if(result == Integer.MAX_VALUE) {
            result = 0;
        }
        return result;
        
    }
}