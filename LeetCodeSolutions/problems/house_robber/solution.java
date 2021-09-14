class Solution {
    public int rob(int[] nums) {
        int a=0;
        int b = nums[0];
        for(int i=1; i<nums.length; i++) {
            int temp = Math.max(b, a+nums[i]);
            a = b;
            b = temp;
        }
        return Math.max(a,b);
    }
}