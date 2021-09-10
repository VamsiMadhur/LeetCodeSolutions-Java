class Solution {
    public boolean canJump(int[] nums) {
        boolean flag = true;
        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i]==0) {
                flag = false;
                int count=2;
                i--;
                while(i>=0) {
                    if(nums[i] >= count) {
                        flag = true;
                        break;
                    }
                    count++;
                    i--;
                }
            }
        }
        return flag;
    }
}