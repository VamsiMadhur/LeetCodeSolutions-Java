class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int median1 = nums[n>>1];
        int result = 0;
        for(int num : nums) result += Math.abs(num-median1);
        return result;
    }
}