class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            int mid = (low+high)/2;
            
            if((mid & 1) == 0) {
                if(nums[mid] == nums[mid+1]) {
                    low = mid+2;
                } else {
                    high = mid;
                }
            } else {
                if(nums[mid] == nums[mid-1]) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
        }
        return nums[low];
    }
}