class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1 ) {
            return nums.length;
        }
        int result = 1;
        int len = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]>nums[i-1]) {
                len++;
            } else {
                if(result<len) {
                    result = len;
                }
                len = 1;
            }
        }
        if(result<len) {
            result = len;
        }
        return result;
    }
}