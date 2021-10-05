class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for(int i=k; i<n; i++) {
            nums[i] = 0;
        }
    }
}