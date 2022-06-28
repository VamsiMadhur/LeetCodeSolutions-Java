class Solution {
    public int findClosestNumber(int[] nums) {
        int min=100001;
        int result = 0, x=0;
        for(int num : nums) {
            x = num<0 ? -num:num;
            if(x < min) {
                min = x;
                result = num;
            } else if(x == min && num > result) {
                result = num;
            }
        }
        return result;
    }
}