class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = -100000;
        int currSum = -100000;
        
        for(int i=0; i<n; i++) {
            if(currSum < 0) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            sum = Math.max(sum, currSum);
        }
        return sum;
    }
}