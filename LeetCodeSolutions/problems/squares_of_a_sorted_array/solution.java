class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j = nums.length-1;
        
        int[] result = new int[j+1];
        int k = j;
        
        while(i<=j) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[k] = nums[i]*nums[i];
                i++;
            } else {
                result[k] = nums[j]*nums[j];
                j--;
            }
            k--;
        }
        return result;
    }
}