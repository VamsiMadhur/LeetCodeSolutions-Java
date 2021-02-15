class Solution {
    public void moveZeroes(int[] nums) {
        int p = -1;
        int q = -1;
        for(int num : nums) {
            if(num!=0) {
                if(q<p) {
                    int temp = nums[p+1];
                    nums[p+1] = nums[q+1];
                    nums[q+1] = temp;
                }
                q++;
            }
            p++;
        }
    }
}