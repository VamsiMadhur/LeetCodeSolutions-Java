class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length, i=0, j=0;
        if(n==1) return nums[0];
        while(n>1) {
            i=0; j=0;
            while(j<n) {
                nums[i++] = Math.min(nums[j], nums[j+1]);
                j+=2;
                if(j>=n) break;
                nums[i++] = Math.max(nums[j], nums[j+1]);
                j+=2;
            }
            n=i;
        }
        return nums[0];
    }
}