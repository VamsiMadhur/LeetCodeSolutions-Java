class Solution {
    public int firstMissingPositive(int[] nums) {
        
        boolean isOnePresent = false;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) isOnePresent = true;
            else if(nums[i] < 1 || nums[i] > nums.length) nums[i] = 1;
        }
        
         if(!isOnePresent) return 1;
        
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            
            if(nums[index] > 0) {
                nums[index] = -nums[index];
            } 
        }
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) return (i+1);
        }
        return nums.length+1;
    }
}