class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int result = 0;
        Arrays.sort(nums);
        int minDiff = 100000;
        for(int i=0; i<n-2;i++) {
            int low = i+1, high = n-1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int diff = Math.abs(sum - target);
                if(diff == 0) return sum;
                if(diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }
                if(sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}