class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        int result = -1;
        for(i=0; i<nums.length; i++) {
            if(nums[i] >= target) {
                result = i;
                break;
            }
        }
        if(i == nums.length) {
            result = i;
        }
        return result;
    }
}