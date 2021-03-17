class Solution {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        int length = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}