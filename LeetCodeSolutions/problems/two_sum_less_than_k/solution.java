class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1) return -1;
        
        Arrays.sort(nums);
        int i=0;
        int j = n-1;
        int sum = -1;
        while(i<j) {
            int temp = nums[i]+nums[j];
            if(temp < k && sum < temp) sum = temp;
            
            if(temp<k) {
                i++;
            } else if(temp >= k) {
                j--;
            }
        }
        return sum;
    }
}