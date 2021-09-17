class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        
        int sum = nums[0];
        int currSum = nums[0];
        
        //1-interval sub-arrays
        for(int i=1; i<n; i++) { 
            currSum = nums[i] + Math.max(currSum, 0);
            sum = Math.max(sum, currSum);
        }
        
        
        //maxRightSum
        int val = nums[n-1];
        
        int[] maxRight = new int[n];
        maxRight[n-1] = val;
        for(int i=n-2; i>=0; i--) {
            val += nums[i];
            maxRight[i] = Math.max(maxRight[i+1], val);
        }
        
        int leftSum = 0;
        for(int i=0; i<n-2; i++) {
            leftSum += nums[i];
            sum = Math.max(sum, leftSum + maxRight[i+1]);
        }
           
        return sum;        
    }
}