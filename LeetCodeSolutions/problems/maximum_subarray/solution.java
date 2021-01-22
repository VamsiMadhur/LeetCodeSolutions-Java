class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int highestSum = nums[0];
        
        for(int i=1; i<=nums.length-1; i++) {
            if(sum<0) {
                sum = nums[i];        
            } else {
                sum+=nums[i];
            }
            
            if(sum>highestSum) {
                highestSum = sum;
            }
        }
        return highestSum;
    }
}