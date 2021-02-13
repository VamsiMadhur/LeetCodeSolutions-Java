class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int total = (len+1)*len;
        total /= 2;
        int arTotal = 0;
        for(int i=0; i<len; i++)  {
            arTotal += nums[i];
        }
        return (total-arTotal);
    }
}