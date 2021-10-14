class Solution {
    public int rob(int[] nums) {
        int a = 0;
        int b = nums[0];
        for(int i=1; i<nums.length; i++) {
            int temp = Math.max(a+nums[i], b);
            a = b;
            b = temp;
        }
        return b;
    }
}