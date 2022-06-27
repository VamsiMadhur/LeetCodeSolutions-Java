class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        int prev = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(prev > nums[i]) {
                if(modified) return false;
                modified = true;
                if(i>=2 && nums[i-2] > nums[i]) continue;
            }
            prev = nums[i];
        }
        return true;
    }
    
}