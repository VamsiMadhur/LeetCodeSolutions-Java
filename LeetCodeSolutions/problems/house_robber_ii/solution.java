class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) {
            return nums[0];
        } if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int iPlus2 = 0;
        int iPlus1 = nums[n-1];
        
        for(int i=n-2; i>=1; i--) {
            int temp = Math.max(iPlus1, iPlus2+nums[i]);
            iPlus2 = iPlus1;
            iPlus1 = temp;
        }
        int answer1 = iPlus1;
        
        iPlus2 = 0;
        iPlus1 = nums[n-2];
        for(int i=n-3; i>=0; i--) {
            int temp = Math.max(iPlus1, iPlus2+nums[i]);
            iPlus2 = iPlus1;
            iPlus1 = temp;
        }
        int answer2 = iPlus1;
        
        return Math.max(answer1, answer2);
    } 
}