class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0, maxHere=0;
        for(int num:nums) {
           max = Math.max(max, maxHere = num == 0 ? 0 : maxHere + 1);
        }
        return max;
    }
}