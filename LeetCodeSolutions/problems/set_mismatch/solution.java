public class Solution {
    public int[] findErrorNums(int[] nums) {
        int diff = 0;
        int squarediff = 0;
        for (int i = 1; i <= nums.length; i++) {
            diff += (i-nums[i-1]);
            squarediff += ((i*i) - (nums[i-1]*nums[i-1]));
        }
        int sum = squarediff/diff;
        
        int d = (sum-diff)/2;
        int m = (sum+diff)/2;
        return new int[]{d, m};
    }
}