class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0, j=nums.length-1, result = 0;
        while(i < j) {
            result = Math.max(result, nums[i++] + nums[j--]);
        }
        return result;
    }
}