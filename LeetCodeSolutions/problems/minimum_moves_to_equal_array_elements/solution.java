class Solution {
    public int minMoves(int[] nums) {
        int lowest = nums[0];
        int result = nums[0];
        for(int i=1; i<nums.length; i++) {
            result += nums[i];
            if(nums[i]<lowest) {
                lowest = nums[i];
            }
        }
        result -= (lowest*nums.length);
        return result;
    }
}