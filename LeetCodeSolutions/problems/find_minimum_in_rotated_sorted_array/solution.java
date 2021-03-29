class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        
        int l = 0;
        int r = nums.length-1;
        
        if(nums[r]>nums[l]) {
            return nums[l];
        }
        
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            
            if(nums[mid]>nums[l]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return nums[0];
    }
}