class Solution {
    public int jump(int[] nums) {
        int count = 0, currentJumpEnd = 0, farthest = 0;

        for(int i=0; i< nums.length-1; i++) {
            farthest = Math.max(farthest, nums[i]+i);
            
            if(i == currentJumpEnd) {
                count++;
                currentJumpEnd = farthest;
            }
        }
        
        return count;
    }
}