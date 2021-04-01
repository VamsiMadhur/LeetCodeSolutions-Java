class Solution {
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        int iPlus2 = 0;
        int iPlus1 = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            int temp = Math.max(iPlus1, iPlus2+nums[i]);
            iPlus2 = iPlus1;
            iPlus1 = temp;
        }
        
        return iPlus1;
    }
}